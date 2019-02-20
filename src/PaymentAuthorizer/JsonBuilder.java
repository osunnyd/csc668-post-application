package PaymentAuthorizer;


import Transaction.Transaction;
import com.google.gson.JsonObject;

//possibly delete this entire class if functions in other classes are better
public class JsonBuilder {
  private Transaction transaction;

  JsonBuilder(Transaction transaction) {
    this.transaction = transaction;

  }

  public String checkAuthorizationJSON(Transaction Transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", Transaction.getBillTotal());
    String json = jsonObj.toString();
    return json;
  }

  public String creditAuthorizationJSON(Transaction Transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", Transaction.getBillTotal());
    jsonObj.addProperty("cardNumber", Transaction.getAmountTendered()); //change amount tendered to credit number
    String json = jsonObj.toString();
    return json;
  }
}
