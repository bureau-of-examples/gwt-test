package zhy2002.gwt.client.rpc;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import zhy2002.gwt.client.model.StockPrice;

@RemoteServiceRelativePath("stockPrices")
public interface StockPriceService extends RemoteService {

    StockPrice[] getPrices(String[] symbols);
}
