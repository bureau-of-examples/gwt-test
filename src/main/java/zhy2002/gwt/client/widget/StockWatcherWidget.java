package zhy2002.gwt.client.widget;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class StockWatcherWidget extends Composite {

    interface StockWatcherWidgetUiBinder extends UiBinder<Widget, StockWatcherWidget> {}

    private static StockWatcherWidgetUiBinder uiBinder = GWT.create(StockWatcherWidgetUiBinder.class);

    public StockWatcherWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    FlexTable stocksFlexTable;
    @UiField
    TextBox newSymbolTextBox;

    @Override
    protected void onLoad() {
        super.onLoad();

        initStocksFlexTable();
        newSymbolTextBox.setFocus(true);
    }

    private void initStocksFlexTable() {
        stocksFlexTable.setText(0, 0, "Symbol");
        stocksFlexTable.setText(0, 1, "Price");
        stocksFlexTable.setText(0, 2, "Change");
        stocksFlexTable.setText(0, 3, "Remove");
    }

    @UiHandler("addStockButton")
    void handleAddStockButtonClick(ClickEvent e) {
        addStock();
    }

    @UiHandler("newSymbolTextBox")
    void handleNewSymbolTextBoxKeyDown(KeyDownEvent e) {
        if(e.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            addStock();
        }
    }

    private void addStock() {
        final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
        newSymbolTextBox.setFocus(true);

        // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
        if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
            Window.alert("'" + symbol + "' is not a valid symbol.");
            newSymbolTextBox.selectAll();
            return;
        }

        newSymbolTextBox.setText("");
    }

}
