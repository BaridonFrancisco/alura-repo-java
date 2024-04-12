package desafioStarWars;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;


public class Logger {

    private String path;
    private String fileName;
    private File file=new File("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\logger.txt");


    public void writeLoggerFile(Throwable throwable) {
        try(  FileOutputStream fileOutputStream=new FileOutputStream(file.getAbsolutePath(),true);
              PrintStream printStream=new PrintStream(fileOutputStream)){

            printStream.print("Date:"+LocalDate.now()+" ");
            throwable.printStackTrace(printStream);
            printStream.flush();


        }catch (IOException e){
            System.out.println("Ha ocurrido un error"+e.getMessage());
        }

    }
    public byte[] bytesArchive() throws IOException {
        byte[]arr=new byte[(int)file.length()];

        if(file.length()>0 && file.canRead()){
             arr= Files.readAllBytes(Path.of(file.getAbsolutePath()));

        }
       return arr;
    }
}
