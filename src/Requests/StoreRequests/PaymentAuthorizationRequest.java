package Requests.StoreRequests;

// Robert Quinones
import Requests.Http.Post;

public class PaymentAuthorizationRequest {
  String uri;
  String statusCode;
  String response;
  Post postRequest;

  public PaymentAuthorizationRequest(String uri) {
    this.uri = uri + "/payments";
  }

  public String authorizePayment(String type, String transactionData) {
    try {
      this.postRequest = new Post(this.uri + "/" + type.toLowerCase());
      this.statusCode = this.postRequest.execute(transactionData);

      if (this.postRequest.containsResponse()) {
        this.response = this.postRequest.getResponse();
      }

    } catch (Exception ex) {
      // Exceptions are thrown where No Body & Non-200 response is present
      this.statusCode = "406";
    }

    return this.statusCode;
  }

  public boolean containsResponse() {
    return !this.response.isEmpty();
  }

  public String getResponse() {
    return this.response;
  }
}