import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class bestTvShows {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeSeries = parser.parse(body);

        for (Map<String,String> serie : listaDeSeries) {
            System.out.println(serie.get("title"));
            System.out.println(serie.get("image"));
            System.out.println(serie.get("imDbRating"));
        }
        
    }
}
