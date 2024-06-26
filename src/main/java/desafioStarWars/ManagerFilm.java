package desafioStarWars;

import com.google.gson.Gson;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class ManagerFilm {

    HttpClient cliente = HttpClient.newHttpClient();


    public List<Film> showFilms() throws IOException, InterruptedException {
        HttpRequest resquest = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/films/"))
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                resquest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        innerArrayResponse innerClass = gson.fromJson(response.body(), innerArrayResponse.class);
        System.out.println(innerClass.getResults());
        return innerClass.getResults();
    }

    private static class innerArrayResponse {
        // cantidad de peliculas -><-
        private int count;
        private List<Film> results;

        public List<Film> getResults() {
            return results;
        }

    }

    public Film getFilm(int numero) throws IOException, InterruptedException {
        HttpRequest resquest = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/films/" + numero))
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                resquest, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();

        return gson.fromJson(response.body(), Film.class);
    }

    public void writeFile(Object obj, File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            bufferedOutputStream.write(obj.toString().getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void writeJson(Object obj,String path,String name) throws IOException {
        FileWriter fileWriter=new FileWriter(path+name+".json");
        Gson gson=new Gson().newBuilder()
                .setPrettyPrinting()
                .create();
        fileWriter.write(gson.toJson(obj));
        fileWriter.close();
    }
}


