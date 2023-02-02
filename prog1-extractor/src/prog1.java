import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import Files.Lines;

/**
 * Takes diseases as input, reports stats, and writes info to output file
 * @author Rae Jones
 */
public class prog1 {
   public static void main(String[] args) {
    System.out.println("The CDC Reports:\n");
        try {
            int cdcLines = 0;
            int cdcChars = 0;
            int cdcWordCount =0;
            //String cdcData;

            File cdcData = new File("./prog1-extractor/data/scabies-CDC.txt");
            Scanner fileReader = new Scanner(cdcData);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
                cdcLines++;

                if (data.length() > 0) {
                    cdcWordCount++;
                }

                for(int i=0; i < data.length(); i++) {
                    cdcChars++;

                    if (data.substring(i, i+1).equals(" ") ) {
                        cdcWordCount++;
                    } 
                }

            }
            
            System.out.println("\nLines in file: " + cdcLines);
            System.out.println("Words in file: " + cdcWordCount);
            System.out.println("Chars in file: " + cdcChars);
            
            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        } 

     /*   System.out.println("\n\nWebMD Reports:\n");
        try {
            File cdcData = new File("./prog1-extractor/data/scabies-webMD.txt");
            Scanner fileReader = new Scanner(cdcData);
            //System.out.println(directory.getAbsolutePath());
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        } 
        */
        
    } 

}