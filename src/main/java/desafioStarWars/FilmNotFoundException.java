package desafioStarWars;

public class FilmNotFoundException extends RuntimeException{

    public FilmNotFoundException() {
    }
    public FilmNotFoundException(String message){
        super(message);
    }
}
