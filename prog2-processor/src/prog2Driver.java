
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

//make sure to credit w3schools for pattern matching

public class prog2Driver {
   public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String cdcInfo = "";
    String currQuestion;
    String currAnswer;
    String currLine;
    Pattern pattern = Pattern.compile("^[A-Z]", Pattern.CASE_INSENSITIVE);
    Matcher matcher;
    boolean matchFound;
    int currIndex = -1;


    ArrayList<QnA> qnAs = new ArrayList<QnA>();
    QnA currQnA;


    try {

        File cdcData = new File("./prog2-processor/data/cdcOutput.txt");
        Scanner fileReader = new Scanner(cdcData);
        

        while (fileReader.hasNextLine()) {
        
            //cdcInfo = cdcInfo + fileReader.nextLine() + "\n";
            currLine = fileReader.nextLine();
            matcher = pattern.matcher(currLine);     
            matchFound = matcher.find();
            
            currQnA = new QnA();

            if(matchFound) {
                //this is a question
                //create a new QnA object; add question to it
                //create new object w linked list here
                qnAs.add(currQnA);
                currIndex++;

                qnAs.get(currIndex).setQuestion(currLine);
                System.out.println("question found");
            } else {
                ///this is an answer
                //add line to current answer
                qnAs.get(currIndex).addToAnswer(currLine);
                System.out.println("answer found");
            }
          
        }

       //System.out.print(cdcInfo);
    
        fileReader.close();
        qnAs.get(1).print();
        qnAs.get(2).print();
        qnAs.get(3).print();
    }

    catch (FileNotFoundException e) {
        System.out.println("no file");
        e.printStackTrace();
    }

    
    /* 
    //System.out.println("What questions do you have about scabies?");
    String userInput = "What is scabies?";
    //keyboard.nextLine();

    if(userInput.contains("What is scabies?")) {
        int indexQuestion = cdcInfo.indexOf(userInput);
        int indexSAnswer = cdcInfo.toString().indexOf("\nC", indexQuestion);

        System.out.println(cdcInfo.substring(indexQuestion + 1, indexSAnswer +1));

        

    } */
    

   } 
    
}
