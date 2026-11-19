import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TriviaGame {
  public static void main(String[] args) throws Exception {
    String url = "https://opentdb.com/api.php?amount=5&difficulty=easy&type=multiple";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    if (response.statusCode()== 200) {
          System.out.println("Trivia Questions received:\n" + response.body());
    } else {
      System.out.println("Data not recieved. Status code: " + response.statusCode());
    }
    
  }
}
