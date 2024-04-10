package desafioStarWars;

import com.google.gson.annotations.SerializedName;


public class Film {

    @SerializedName("title")
    private String title;
    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;

    public Film() {
    }

    public Film(String title, String director, String producer, String releaseDate) {
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", productor='" + producer + '\'' +
                ", fechaLanzamiento='" + releaseDate + '\'' +
                '}';
    }
}
