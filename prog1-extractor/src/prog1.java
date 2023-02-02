import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
//import Files.Lines;

/**
 * Takes diseases as input, reports stats, and writes info to output file
 * Used Programiz as a source for writing to files easily: https://www.programiz.com/java-programming/printwriter
 * @author Rae Jones
 */
public class prog1 {
   public static void main(String[] args) {
    
        try {
            int cdcLines = 0;
            int cdcChars = 0;
            int cdcWordCount =0;
            //String cdcData;

            File cdcData = new File("./prog1-extractor/data/scabies-CDC.txt");
            Scanner fileReader = new Scanner(cdcData);
            PrintWriter output = new PrintWriter("output.txt");

            output.println("The CDC Reports:\n");

            while (fileReader.hasNextLine()) {
            
                String data = fileReader.nextLine();
                output.println(data);
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
            
            output.println("\nLines in file: " + cdcLines);
            output.println("Words in file: " + cdcWordCount);
            output.println("Chars in file: " + cdcChars);
            
            output.close();
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