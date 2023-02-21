
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

                qnAs.get(currIndex).setQuestion(currLine.trim());
                //System.out.println("question found");
            } else {
                ///this is an answer
                //add line to current answer
                qnAs.get(currIndex).addToAnswer(currLine.trim());
                //System.out.println("answer found");
            }
          
        }

       //System.out.print(cdcInfo);
    
        fileReader.close();
        /*
        qnAs.get(1).print();
        qnAs.get(2).print();
        qnAs.get(3).print();
        */
    }

    catch (FileNotFoundException e) {
        System.out.println("no file");
        e.printStackTrace();
    }
    
    System.out.println("What questions do you have about scabies?\n Enter STOP to exit chat");
    String userInput = keyboard.nextLine();

    while (!userInput.equalsIgnoreCase("stop")) {
        if(userInput.contains("What is scabies?") | userInput.contains("what is scabies?")) {
            System.out.println(qnAs.get(1).getAnswer());
        }

        else if (userInput.contains("symptom")) {
            System.out.println(qnAs.get(2).getQuestion());
            System.out.println(qnAs.get(2).getAnswer());
        }
        else if (userInput.contains("who") | userInput.contains("Who")) {
            System.out.println(qnAs.get(3).getAnswer());
        }
        else if (userInput.contains("travel") ) {
            System.out.println(qnAs.get(4).getAnswer());
        }
        userInput = keyboard.nextLine();
    }
    

    /* 
    System.out.println("POOOOOOOOOOOP");
    System.out.println(qnAs.get(2).getAnswer());

    System.out.println("trying fancy way");
    System.out.println(qnAs.));
    */

   } 
    
}
