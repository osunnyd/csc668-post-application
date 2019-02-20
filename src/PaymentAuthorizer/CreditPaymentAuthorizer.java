package PaymentAuthorizer;

// Robert Quinones
import Transaction.Transaction;
import Requests.StoreRequests.PaymentAuthorizationRequest;

public class CreditPaymentAuthorizer extends PaymentAuthorizer {

  PaymentAuthorizationRequest authorizationRequest;

  @Override
  public Boolean authorizePayment(Transaction transaction, String URI) {
    if (transaction.getAmountTendered().length() != 5) {
      super.addError("Invalid Credit Card Number");
      return false;
    }

    // TODO DEBUG STRING, WE NEED REAL JSON
    String authorizationData = "{ \"amount\": 123.45, \"cardNumber\":12345 }";

    this.authorizationRequest = new PaymentAuthorizationRequest(URI);
    String authorizationResultCode = this.authorizationRequest.authorizePayment("CREDIT", authorizationData);

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
}