package PaymentAuthorizer;

// Robert Quinones

import Transaction.Transaction;
import Requests.StoreRequests.PaymentAuthorizationRequest;

public class CreditPaymentAuthorizer extends PaymentAuthorizer {

  PaymentAuthorizationRequest authorizationRequest;

  @Override
  public Boolean authorizePayment(Transaction transaction, String URI) {


    String authorizationData = transaction.getAuthorizationJSON();

    this.authorizationRequest = new PaymentAuthorizationRequest(URI);
    String authorizationResultCode = this.authorizationRequest.authorizePayment("CREDIT", authorizationData);

    switch (authorizationResultCode) {
    case "202":
      return true;

    case "400":
      super.addError(this.authorizationRequest.getResponse());
      break;

    case "406":
      return false;

    default:
      return false;
    }

    return false;
  }

}