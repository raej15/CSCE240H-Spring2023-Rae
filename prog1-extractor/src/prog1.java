import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Takes diseases as input, reports stats, and writes info to output file
 * Used Programiz as a source for writing-to-files with PrintWriter: https://www.programiz.com/java-programming/printwriter
 * @author Rae Jones
 */
public class prog1 {
   public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What disease are you looking for information about? (input Scabies)");
        if (keyboard.nextLine().equalsIgnoreCase("scabies")) {
                
            try {
                int cdcLines = 0;
                int cdcChars = 0;
                int cdcWordCount =0;

                File cdcData = new File("./prog1-extractor/data/scabies-CDC.txt");
                Scanner fileReader = new Scanner(cdcData);
                PrintWriter cdcOutput = new PrintWriter("./prog1-extractor/test/cdcOutput.txt");

                cdcOutput.println("The CDC Reports:\n");

                while (fileReader.hasNextLine()) {
                
                    String data = fileReader.nextLine();
                    if (data.length() > 0) {
                        if (!(data.substring(data.length() - 1, data.length()).equals(":")) & !(data.substring(data.length() - 1, data.length()).equals("?"))) {
                            cdcOutput.println("\t" + data);
                        }
                        else {
                            cdcOutput.println(data);
                        }
                    }
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
                
                cdcOutput.println("\nLines in original file: " + cdcLines);
                cdcOutput.println("Words in original file: " + cdcWordCount);
                cdcOutput.println("Chars in original file: " + cdcChars);
                
                cdcOutput.close();
                fileReader.close();
            }

            catch (FileNotFoundException e) {
                System.out.println("no file");
                e.printStackTrace();
            } 

            try {
                int webMDLines = 0;
                int webMDChars = 0;
                int webMDWordCount =0;
                //String cdcData;

                File webMDData = new File("./prog1-extractor/data/scabies-webMD.txt");
                Scanner fileReader = new Scanner(webMDData);
                PrintWriter webMDOutput = new PrintWriter("./prog1-extractor/test/webMDOutput.txt");

                webMDOutput.println("WebMD Reports:\n");

                while (fileReader.hasNextLine()) {
                
                    String data = fileReader.nextLine();
                    if (data.length() > 0) {
                        if (!(data.substring(data.length() - 1, data.length()).equals(":")) & !(data.substring(data.length() - 1, data.length()).equals("?"))) {
                            webMDOutput.println("\t" + data);
                        }
                        else {
                            webMDOutput.println(data);
                        }
                    }
                    webMDLines++;

                    if (data.length() > 0) {
                        webMDWordCount++;
                    }

                    for(int i=0; i < data.length(); i++) {
                        webMDChars++;

                        if (data.substring(i, i+1).equals(" ") ) {
                            webMDWordCount++;
                        } 
                    }
                    

                }
                
                webMDOutput.println("\nLines in original file: " + webMDLines);
                webMDOutput.println("Words in original file: " + webMDWordCount);
                webMDOutput.println("Chars in original file: " + webMDChars);
                
                webMDOutput.close();
                fileReader.close();
            }

            catch (FileNotFoundException e) {
                System.out.println("no file");
                e.printStackTrace();
            } 
            System.out.println("Successfully wrote output files.");
        }

        else {
            System.out.println("I do not have any information about that. Try asking about scabies next times. \nEXITING PROGRAM");
            System.exit(0);
        }


        
    } 

}