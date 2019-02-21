package Transaction.JSONBuilder;

//Juan Valdez

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.HashMap;
import Main.SalesLineItem;
import Transaction.Transaction;

//possibly delete this entire class if functions in other classes are better
public abstract class JsonBuilder {
  public static final HashMap<String, JsonBuilder> jsonBuilders = new HashMap<String, JsonBuilder>();

  static {
    jsonBuilders.put("CASH", new CashJsonBuilder());
    jsonBuilders.put("CREDIT", new CreditJsonBuilder());
    jsonBuilders.put("CHECK", new CheckJsonBuilder());
  }

  public static JsonBuilder getJsonBuilder(String paymentType) {
    return jsonBuilders.get(paymentType);
  }

  public static boolean containsPaymentAuthorizer(String paymentType) {
    return jsonBuilders.containsKey(paymentType);
  }

  public abstract String getAuthorizationJSON(Transaction transaction);

  public abstract JsonObject getTenderedMembers(Transaction transaction);

  public String createSaleJSON(Transaction transaction) {
    JsonObject jsonObj = new JsonObject();

    jsonObj.addProperty("customer", transaction.getCustomer().getName());
    jsonObj.addProperty("timeOfSale", transaction.getCustomer().getDate());
    jsonObj.add("items", itemsToJsonArray(transaction.getPurchasedItems()));
    jsonObj.addProperty("total", transaction.getBillTotal());
    jsonObj.add("tendered", getTenderedMembers(transaction));
    jsonObj.addProperty("returned", transaction.getChange());

    return jsonObj.toString();
  }

  private JsonArray itemsToJsonArray(ArrayList<SalesLineItem> purchasedItems) {
    JsonArray items = new JsonArray();

    for (int i = 0; i < purchasedItems.size(); i++) {
      JsonObject itemObject = new JsonObject();
      SalesLineItem currentItem = purchasedItems.get(i);

      itemObject.addProperty("upc", currentItem.getUPC().getUPC());
      itemObject.addProperty("quantity", currentItem.getQuantity());
      itemObject.addProperty("price", currentItem.getUnitPrice());

      items.add(itemObject);
    }

    return items;
  }
}
