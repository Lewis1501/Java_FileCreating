import java.io.IOException;

/**
 * Created by Sony VAIO on 10/12/2015.
 */


public class Main{

    public static void main(String[] args) throws IOException{
        InputOutput IO = new InputOutput();
        IO.setFile("Stringg.txt");
        IO.renameFile(IO.getRandomFile(),"New_Name.txt");
        IO.writeToFile("Stringg.txt"," writing to file");
        IO.deleteFilr("New_Name.txt");
        IO.deleteFilr("random.txt");
        IO.addToFile("Stringg.txt", " More and MOre and MOre");
    }
}
