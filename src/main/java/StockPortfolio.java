import org.json.simple.parser.ParseException;

import java.io.IOException;

public class StockPortfolio {
    public static void main(String[] args) throws IOException, ParseException {
        Stock stock = new Stock();
        stock.readStocks();
        stock.createPortfolio();
    }
}
