package PaymentAuthorizer;


import Transaction.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

//possibly delete this entire class if functions in other classes are better
public class JsonBuilder {
  private Transaction transaction;

  JsonBuilder(Transaction transaction) {
    this.transaction = transaction;

  }

  public String checkAuthorizationJSON(Transaction transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", transaction.getBillTotal());
    String json = jsonObj.toString();
    return json;
  }

  public String creditAuthorizationJSON(Transaction transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", transaction.getBillTotal());
    jsonObj.addProperty("cardNumber", transaction.getAmountTendered()); //change amount tendered to credit number
    String json = jsonObj.toString();
    return json;
  }

  public String createSaleJson(Transaction transaction) {
    Gson gson = new Gson();
    String json = gson.toJson(transaction);
    return json;
  }
}
