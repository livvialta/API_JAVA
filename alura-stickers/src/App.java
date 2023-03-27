import java.net.URI;
import java.net.http.HttpClient; 
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexao HTTP (Pedir algo e adquirir algo em resposta) e buscar os top 250 filmes.

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // HTTP - (Protocolo que utilizamos para se comunicar na web. HTTPS é aquele que usa o padrao de seguranca.) - Pedir algo e adquirir algo em resposta.

    
        //extrair só os dados que interessam (titulo, post, classificacao)

        JsonParser parser = new JsonParser();   
        // or var jsonParser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // MAP: associa uma chave a um valor. É necessario dizer o tipo.


        //exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get( "title")); 
            System.out.println(filme.get( "image"));
            System.out.println(filme.get( "imDbRating"));
        }



    }
}
