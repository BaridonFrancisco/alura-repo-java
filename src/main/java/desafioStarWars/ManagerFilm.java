package desafioStarWars;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class ManagerFilm {

    HttpClient cliente = HttpClient.newHttpClient();
    

    public void showFilms() throws IOException, InterruptedException {
        HttpRequest resquest=HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/films/"))
                .GET()
                .build();

        HttpResponse<String> response= cliente.send(
                resquest,HttpResponse.BodyHandlers.ofString());

        Gson gson=new Gson().newBuilder().setPrettyPrinting().create();
        innerArrayResponse innerClass=gson.fromJson(response.body(), innerArrayResponse.class);
        System.out.println(innerClass.getResults());
    }
    private static class innerArrayResponse{
        // cantidad de peliculas -><-
        private int count;
        private List<Film> results;

        public List<Film> getResults() {
            return results;
        }

    }
    public Film getFilm(){

        


        return new Film();
    }

}


