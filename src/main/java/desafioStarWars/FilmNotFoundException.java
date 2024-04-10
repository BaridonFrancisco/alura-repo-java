package desafioStarWars;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String message){
        super(message);
    }
}
