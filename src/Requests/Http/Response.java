package Requests.Http;

// Robert Quinones
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;

public class Response {
  private int statusCode;
  private String result;
  private BufferedReader bodyReader;
  private HttpURLConnection connection;

  public Response(HttpURLConnection connection) throws IOException {
    this.result = "";
    this.connection = connection;

    this.createReader();

    this.read();
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public String getBody() {
    return this.result;
  }

  private void createReader() {
    try {
      this.statusCode = connection.getResponseCode();
      this.bodyReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    } catch (IOException ioex) {
      // Not clear what was happening, so noting here:
      // Non 200s raise IOException when getResponseCode invoked
      // So we want to get the error stream instead to read the body
      this.bodyReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
    }
  }

  private Boolean isNotAccepted() {
    return this.statusCode != 202;
  }

  private void read() throws IOException {
    String line;

    while ((line = bodyReader.readLine()) != null) {
      this.result = this.result + line;
    }

    // Set Non-200 return codes, since cannot be set in createReader
    // 202 responses also have no body, it could be a valid response already
    if (isNotAccepted() && !result.isEmpty()) {
      this.statusCode = 400;
      // 406 Will be implied by thrown Exception, and returned once
      // Post's execute has completed
    }
  }
}