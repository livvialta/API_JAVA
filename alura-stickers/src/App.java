import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //conexao HTTP
        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

    //extrair só os dados que quero

    JsonParser parser = new JsonParser();   
    List<Map<String, String>> listaFilmesPopulares = parser.parse(body);

    //printar na tela os dados ja manipulados
for (Map<String,String> filme : listaFilmesPopulares) {
    System.out.println(filme.get("title"));
    System.out.println(filme.get("image"));
    System.out.println(filme.get("imDbRating"));
}
    }
}

