package desafioStarWars;

import java.io.File;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
        Logger logger=new Logger();
        File f=new File("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\logger.txt");
        System.out.println(f.length());
    }
}
