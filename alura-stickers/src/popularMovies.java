import java.net.URI;
import java.net.http.HttpClient; 
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class popularMovies {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexao HTTP (Pedir algo e adquirir algo em resposta) e buscar os top 250 filmes.

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // HTTP - (Protocolo que utilizamos para se comunicar na web. HTTPS é aquele que usa o padrao de seguranca.) - Pedir algo e adquirir algo em resposta.

        //extrair só os dados que interessam (titulo, post, classificacao)

        JsonParser parser = new JsonParser();
        // or var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // MAP: associa uma chave a um valor. É necessario dizer o tipo.

        //exibir e manipular os dados

        for (int i = 0; i < 3; i++) { //nessa linha a um for para definir quantos filmes vao ser printados, ai no caso coloquei 3.
            Map<String,String> filme = listaDeFilmes.get(i);

            System.out.println("\u001b[38;2;255;255;255m \u001b[48;2;42;122;228m Título:\u001b[m" + " " + filme.get("title")); 

           
            System.out.println("\u001b[1m Post do Filme: \u001b[m" + filme.get("image"));

            Double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int n_stars = (int) Math.round(classificacao);

            System.out.println("\u001b[38;5;214m \u001b[48;5;153m Classificação: \u001b[m"); 
            int star = 1;
        while (star <= 5) {
            if (n_stars >= 9) {
                for (int j = 1; j <= 5; j++) {
                    System.out.print("⭐");
                }
                break;
            } 
            else if (n_stars == 7 || n_stars == 8) {
                for (int j = 1; j <= 4; j++) {
                    System.out.print("⭐");
                }
                break;
            } 
            else if (n_stars == 5 || n_stars == 6) {
                for (int j = 1; j <= 3; j++) {
                    System.out.print("⭐");
                }
                break;
            } 
            else if (n_stars <= 4) {
                for (int j = 1; j <= 2; j++) {
                    System.out.print("⭐");
                }
                break;
            } 
            System.out.print("⭐");
            star++;
        }
        System.out.print(" - " + classificacao);
        System.out.println("\n"); 

            
        }
    }
}
