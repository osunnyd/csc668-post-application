package Http;

import java.io.IOException;
import java.net.MalformedURLException;

public class Post extends RestRequest {
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

    Response response = new Response(connection);

    System.out.println(response.getBody());

    connection.disconnect();

    return Integer.toString(response.getStatusCode());
  }
}