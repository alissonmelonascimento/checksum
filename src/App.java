import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class App {

    static final String filePath = "MY_FOLDER\\MY_FILE.pdf";
    static final String fileNewPath = "MY_FOLDER\\checksum.txt";

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando");

        FileWriter newFileWriter = new FileWriter(fileNewPath);
        
        Path path = Paths.get(filePath);
        InputStream inputStream = Files.newInputStream(path);

        newFileWriter.write("["+Base64.getEncoder().encodeToString( inputStream.readAllBytes() )+"]");
        inputStream.close();
        newFileWriter.close();

        System.out.println("Concluído");

    }
}
