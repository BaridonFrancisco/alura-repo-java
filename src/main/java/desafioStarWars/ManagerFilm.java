package desafioStarWars;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ManagerFilm {

    HttpClient cliente = HttpClient.newHttpClient();

    public List<Film> showFilms(){
            HttpRequest resquest=HttpRequest.newBuilder()
                                .uri(URI.create("https://swapi.dev/api/films/"))
                                .GET()
                                .build();
        try {
            HttpResponse<String> response=cliente.send(resquest,HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>();
    }
}
