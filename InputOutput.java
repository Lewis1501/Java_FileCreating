import javax.swing.*;
import java.io.*;

/**
 * Created by Sony VAIO on 10/12/2015.
 */
public class InputOutput extends JFrame{

    private static final String EXISTS = "THIS FILE EXISTS";
    static String filePath, parentDirectory;
    static File randomDir, randomFile, randomFile2;


    public void setFile(String newFile){
        randomDir = new File("C:/Users/Sony VAIO/Desktop/Lewis");
        randomDir.mkdir();
        randomFile = new File(newFile);
        randomFile2 = new File("C:/Users/Sony VAIO/Desktop/Lewis/Lewis.txt");

        try
        {
            randomFile.createNewFile();
            randomFile2.createNewFile();

            filePath = randomFile.getCanonicalPath();
            System.out.println(filePath);
        } catch (IOException e){
            e.printStackTrace();
        }
        if (randomFile.exists()){
            System.out.println(EXISTS);
            System.out.println("Is " + randomFile + " readable: " + randomFile.canRead());
            System.out.println(randomFile + " is not readable now " + randomFile.setReadable(false));
        }
    }

    public static File getRandomFile() {
        return randomFile;
    }

    public void renameFile(File fileName, String changeTo){
        if(fileName.exists()) {
            fileName.renameTo(new File(changeTo));
            System.out.println("Your file name has been changed to: " + changeTo);
        } else {
            System.out.println("File doesnt't exist.");
        }
        }

    public void writeToFile(String writeTo, String write)  {
        File writeTTo = new File(writeTo);
        if(!writeTTo.exists()){
            try {
                writeTTo.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(writeTo));
                bw.write(write);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("You have written to \'" + writeTo + '\'');

        }

        if(writeTTo.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(writeTo));
                bw.write(write);
                bw.close();

            } catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("You have written to \'" + getRandomFile() + '\'');

        }
    }

    public void deleteFilr(String delete){
        File file = new File(delete);
        if(file.exists()) {
            file.delete();

            System.out.println(file + " has been deleted.");
        } else if(!file.exists()){
            System.out.println(file + " doesn't exist.");
        }
        }

    public void addToFile(String fileName, String textToAdd) throws IOException{
        File file = new File(fileName);
        if(file.exists()){
            /**
             * Put to append mode to write to an existing file. use the
             * FileWriter Constructor (new Filewriter(FileName fileName, Boolean opp)
             * set to true to enable append mode.
             */
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(textToAdd);
            bw.close();
        }
    }
}
