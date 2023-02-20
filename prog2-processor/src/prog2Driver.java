
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class prog2 {
   public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String cdcInfo = "";
    //System.out.println("do you have gay disease???/");
    //String userInput = keyboard.nextLine();

   // System.out.println(userInput);

    try {

        File cdcData = new File("./prog2-processor/data/cdcOutput.txt");
        Scanner fileReader = new Scanner(cdcData);
        

        while (fileReader.hasNextLine()) {
        
            cdcInfo = cdcInfo + fileReader.nextLine() + "\n";
        }

       // System.out.print(cdcInfo);
    
        fileReader.close();
    }

    catch (FileNotFoundException e) {
        System.out.println("no file");
        e.printStackTrace();
    }

    //System.out.println("What questions do you have about scabies?");
    String userInput = "What is scabies?";
    //keyboard.nextLine();

    if(userInput.contains("What is scabies?")) {
        int indexQuestion = cdcInfo.indexOf(userInput);
        int indexSAnswer = cdcInfo.toString().indexOf("\nC", indexQuestion);

        System.out.println(cdcInfo.substring(indexQuestion + 1, indexSAnswer +1));

        

    } 
    
    

    /*for (int i = 0; i<cdcInfo.length(); i++) {
        if (cdcInfo.startsWith("\n\t")) {

       }
    } */

   } 
    
}
