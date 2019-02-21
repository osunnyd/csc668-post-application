package Requests.Http;

// Robert Quinones
import java.io.IOException;
import java.net.MalformedURLException;

public class Post extends RestRequest {
  Response response;

  public Post(String uri) throws MalformedURLException, IOException {
    super(uri);
    connection.setRequestMethod("POST");
  }

  public String execute() throws IOException {
    return this.execute("");
  }

  public String execute(String body) throws IOException {
    connection.setDoOutput(true);
    connection.getOutputStream().write(body.getBytes("UTF-8"));

    this.response = new Response(connection);

    System.out.println(response.getBody());

    connection.disconnect();

    return Integer.toString(response.getStatusCode());
  }

  public Boolean containsResponse() {
    return !this.response.getBody().isEmpty();
  }

  public String getResponse() {
    return this.response.getBody();
  }
}