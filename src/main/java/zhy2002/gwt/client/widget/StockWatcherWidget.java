package zhy2002.gwt.client.widget;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import zhy2002.gwt.client.model.StockPrice;
import zhy2002.gwt.client.rpc.StockPriceService;
import zhy2002.gwt.client.rpc.StockPriceServiceAsync;

import java.util.ArrayList;
import java.util.List;

public class StockWatcherWidget extends Composite {

    interface StockWatcherWidgetUiBinder extends UiBinder<Widget, StockWatcherWidget> {
    }

    private static StockWatcherWidgetUiBinder uiBinder = GWT.create(StockWatcherWidgetUiBinder.class);

    public StockWatcherWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    private List<String> stocks = new ArrayList<String>();

    @UiField
    FlexTable stocksFlexTable;
    @UiField
    TextBox newSymbolTextBox;

    private StockPriceServiceAsync stockPriceService;

    @Override
    protected void onLoad() {
        super.onLoad();

        initStocksFlexTable();
        setupRefreshTimer();
        newSymbolTextBox.setFocus(true);
        this.addStyleName("gwt-widget");
        this.addStyleName(this.getClass().getSimpleName());
    }

    private void initStocksFlexTable() {
        stocksFlexTable.setText(0, 0, "Symbol");
        stocksFlexTable.setText(0, 1, "Price");
        stocksFlexTable.setText(0, 2, "Change");
        stocksFlexTable.setText(0, 3, "Remove");
    }

    private void setupRefreshTimer() {
        Timer refreshTimer = new Timer() {
            @Override
            public void run() {
                refreshStocks();
            }
        };
        refreshTimer.scheduleRepeating(8000);
    }

    private String[] getCurrentSymbols() {
        String[] result = new String[stocks.size()];
        stocks.toArray(result);
        return result;
    }

    private void refreshStocks() {
        if (stockPriceService == null) {
            stockPriceService = GWT.create(StockPriceService.class);
        }

        if (stocks.isEmpty())
            return;

        stockPriceService.getPrices(getCurrentSymbols(), new AsyncCallback<StockPrice[]>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Refresh price request failed: " + caught.getMessage());
            }

            @Override
            public void onSuccess(StockPrice[] stocks) {
                for (int i = 0; i < stocks.length; i++) {
                    stocksFlexTable.setText(i + 1, 1, NumberFormat.getCurrencyFormat().format(stocks[i].getPrice()));
                    stocksFlexTable.setText(i + 1, 2, NumberFormat.getDecimalFormat().format(stocks[i].getChange()) + "%");
                }
            }
        });
    }

    @UiHandler("addStockButton")
    void handleAddStockButtonClick(ClickEvent e) {
        addStock();
    }

    @UiHandler("addFromServerButton")
    void handleAddFromServerButtonClick(ClickEvent e) {
        addFromServer();
    }

    @UiHandler("newSymbolTextBox")
    void handleNewSymbolTextBoxKeyDown(KeyDownEvent e) {
        if (e.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            addStock();
        }
    }

    private void addFromServer() {
        refreshStocks();
    }

    private void addStock() {
        final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
        newSymbolTextBox.setFocus(true);

        // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
        if (!symbol.matches("^[0-9A-Z.]{1,10}$")) {
            Window.alert("'" + symbol + "' is not a valid symbol.");
            newSymbolTextBox.selectAll();
            return;
        }

        newSymbolTextBox.setText("");

        if (stocks.contains(symbol)) {
            return;
        }
        stocks.add(symbol);
        int row = stocksFlexTable.getRowCount();
        stocksFlexTable.setText(row, 0, symbol);
        Button removeStockButton = new Button();
        removeStockButton.setText("Remove");
        removeStockButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                int index = stocks.indexOf(symbol);
                stocks.remove(index);
                stocksFlexTable.removeRow(index + 1);
            }
        });
        stocksFlexTable.setWidget(row, 3, removeStockButton);
        refreshStocks();
    }

}
