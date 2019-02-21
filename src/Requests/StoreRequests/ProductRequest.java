package Requests.StoreRequests;

// Robert Quinones
import Requests.Http.Get;

public class ProductRequest {
  String uri;

  public ProductRequest(String uri) {
    this.uri = uri + "/products";
  }

  public String getProducts() {
    try {
      return new Get(this.uri).execute();

    } catch (Exception ex) {
      ex.printStackTrace();

      return "Connection to " + this.uri + "/products has failed.";
    }
  }
}