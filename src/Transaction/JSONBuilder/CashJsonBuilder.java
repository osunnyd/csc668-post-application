package Transaction.JSONBuilder;

// Robert Quinones
import Transaction.Transaction;
import com.google.gson.JsonObject;

public class CashJsonBuilder extends JsonBuilder {

  @Override
  public String getAuthorizationJSON(Transaction transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", transaction.getBillTotal());
    String json = jsonObj.toString();
    return json;
  }

  @Override
  public JsonObject getTenderedMembers(Transaction transaction) {
    JsonObject tenderedMembers = new JsonObject();

    tenderedMembers.addProperty("type", transaction.getPaymentType());
    tenderedMembers.addProperty("amount", transaction.getBillTotal());

    return tenderedMembers;
  }
}