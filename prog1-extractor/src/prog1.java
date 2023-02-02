import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Takes diseases as input, reports stats, and writes info to output file
 * @author Rae Jones
 */
public class prog1 {
   public static void main(String[] args) {
    //System.out.println(directory.getAbsolutePath());

        System.out.println("The CDC Reports:\n");
        try {
            File cdcData = new File("./prog1-extractor/data/scabies-CDC.txt");
            Scanner myReader = new Scanner(cdcData);
            //System.out.println(directory.getAbsolutePath());
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        } 

        System.out.println("\n\nWebMD Reports:\n");
        try {
            File cdcData = new File("./prog1-extractor/data/scabies-webMD.txt");
            Scanner myReader = new Scanner(cdcData);
            //System.out.println(directory.getAbsolutePath());
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        } 

        
    } 

}