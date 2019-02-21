package Transaction.JSONBuilder;

// Robert Quinones
import Transaction.Transaction;
import com.google.gson.JsonObject;

public class CreditJsonBuilder extends JsonBuilder {

  @Override
  public String getAuthorizationJSON(Transaction transaction) {
    JsonObject jsonObj = new JsonObject();

    jsonObj.addProperty("amount", transaction.getBillTotal());
    jsonObj.addProperty("cardNumber", Float.parseFloat(transaction.getAmountTendered()));

    String json = jsonObj.toString();

    return json;
  }

  @Override
  public JsonObject getTenderedMembers(Transaction transaction) {
    JsonObject tenderedMembers = new JsonObject();

    tenderedMembers.addProperty("type", transaction.getPaymentType());
    tenderedMembers.addProperty("amount", transaction.getBillTotal());
    tenderedMembers.addProperty("cardNumber", Float.parseFloat(transaction.getAmountTendered()));

    return tenderedMembers;
  }
}