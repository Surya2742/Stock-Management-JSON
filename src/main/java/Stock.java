import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class Stock {
    ShareDetails[] stockList;


    void readStocks() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray obj = (JSONArray) parser.parse(new FileReader("file.json"));
        System.out.println(obj);
        int i;
        stockList = new ShareDetails[obj.size()];
        i = 0;
        for (Object o : obj) {
            JSONObject person = (JSONObject) o;
            stockList[i] = new ShareDetails();

            int sharePrice = Integer.parseInt((String) person.get("SharePrice"));
            stockList[i].setValue(sharePrice);

            int numberOfShare = Integer.parseInt((String) person.get("NumberOfShare"));
            stockList[i].setQuantity(numberOfShare);

            String stockName = (String) person.get("StockName");
            stockList[i].setShareName(stockName);
            i++;
        }

    }

    public void createPortfolio() {
        double totalPortFolioValue = 0;
        for (int i = 0; i < stockList.length; i++) {
            ShareDetails share = stockList[i];
            double totalShareValue = (share.value * share.quantity);
            totalPortFolioValue += totalShareValue;
            System.out.println(share.getShareName() + "\t\tINR " + share.getValue() + "\t"
                    + share.getQuantity() + "\t INR " + totalShareValue);
        }
        System.out.println("---------------------------------------------");
        System.out.println("Total portfolio value is : INR " + totalPortFolioValue);
    }
}


