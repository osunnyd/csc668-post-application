package Requests.StoreRequests;

// Robert Quinones
import Requests.Http.Post;

public class PaymentAuthorizationRequest {
  String uri;
  String statusCode;

  public PaymentAuthorizationRequest(String uri) {
    this.uri = uri + "/payments";
  }

  public String authorizePayment(String type, String transactionData) {

    // DEBUG - Delete Later
    System.out.println("<Transaction Data Sent to POST " + this.uri + "/" + type.toLowerCase() + ">");
    System.out.println(transactionData);

    try {
      this.statusCode = new Post(this.uri + "/" + type.toLowerCase()).execute(transactionData);
    } catch (Exception ex) {
      // Exceptions are thrown where No Body & Non-200 response is present
      this.statusCode = "406";
    }

    return this.statusCode;
  }
}