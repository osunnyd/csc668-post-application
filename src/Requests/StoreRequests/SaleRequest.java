package Requests.StoreRequests;

// Robert Quinones
import Requests.Http.Put;
import java.io.IOException;
import java.net.MalformedURLException;

public class SaleRequest {
  String uri;
  String statusCode;
  String id;
  String errors;

  public SaleRequest(String uri) {
    this.uri = uri + "/sales";
  }

  public String createSale(String transactionData) {
    try {
      String result = new Put(this.uri).execute(transactionData);

      if (result.contains("id")) {
        this.statusCode = "201";
        this.id = result; // PARSE RESULT TO GET ID NUMBER

      } else if (result.contains("error")) {
        this.statusCode = "400";
        this.errors = result; // PARSE RESULT TO GET ERRORS

      } else {
        this.statusCode = "500";
      }

    } catch (MalformedURLException mex) {
      System.out.println("MalformedURLException");
      mex.printStackTrace();
    } catch (IOException iex) {
      System.out.println("IOException");
      iex.printStackTrace();
    }

    return this.statusCode;
  }

  public String getId() {
    return this.id;
  }

  public String getErrors() {
    return this.errors;
  }
}