package PaymentAuthorizer;

// Robert Quinones

import Transaction.Transaction;
import Requests.StoreRequests.PaymentAuthorizationRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CheckPaymentAuthorizer extends PaymentAuthorizer {

  PaymentAuthorizationRequest authorizationRequest;

  @Override
  public Boolean authorizePayment(Transaction transaction, String URI) {
    if (transaction.getChange() != 0) {
      super.addError("Insufficient Amount Tendered");
      return false;
    }

    // TODO DEBUG STRING, WE NEED REAL JSON
    String authorizationData = "{ \"amount\": 123.45 }";

    this.authorizationRequest = new PaymentAuthorizationRequest(URI);
    String authorizationResultCode = this.authorizationRequest.authorizePayment("CHECK", authorizationData);

    switch (authorizationResultCode) {
      case "202":
        return true;

      case "400":
        // TODO Add Errors Individually
        super.addError(this.authorizationRequest.getResponse());
        break;

      case "406":
        return false;

      default:
        return false;
    }

    return false;
  }

  public String checkAuthorizationJSON(Transaction Transaction) {
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("amount", Transaction.getBillTotal());
    String json = jsonObj.toString();
    return json;
  }
}