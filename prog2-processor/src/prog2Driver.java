
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
        QnA wcurrQnA;

        try {

            File cdcData = new File("./prog2-processor/data/cdcOutput.txt");
            Scanner fileReader = new Scanner(cdcData);
            

            while (fileReader.hasNextLine()) {
            
                //cdcInfo = cdcInfo + fileReader.nextLine() + "\n";
                currLine = fileReader.nextLine();
                matcher = pattern.matcher(currLine);     
                matchFound = matcher.find();
                
                wcurrQnA = new QnA();

                if(matchFound) {
                    //this is a question
                    //create a new QnA object; add question to it
                    //create new object w linked list here
                    qnAs.add(wcurrQnA);
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

        currIndex = 3;

        try {

            File webMDData = new File("./prog2-processor/data/webMDOutput.txt");
            Scanner fileReader = new Scanner(webMDData);
            

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
            qnAs.get(4).print();
            qnAs.get(5).print();
            qnAs.get(6).print();
            qnAs.get(7).print();
            */
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        }
        
        System.out.println("What questions do you have about scabies?\n Enter STOP to exit chat");
        String userInput = keyboard.nextLine();

        //String keyword = "";
        while (!userInput.equalsIgnoreCase("stop")) {
            //keyword = userInput;
        if(userInput.contains("What is scabies") | userInput.contains("what is scabies")) {
                System.out.println(qnAs.get(1).getAnswer());
                System.out.println("Would you like more info? say <more information> or <no>");
                userInput = keyboard.nextLine();
                if (!userInput.equalsIgnoreCase("no")) {
                    System.out.println("From webMD:");
                    System.out.println(qnAs.get(5).getAnswer());
                }
            //keyword = "What is Scabies?";

            }

            else if (userInput.contains("symptom")) {
                System.out.println(qnAs.get(2).getQuestion());
                System.out.println(qnAs.get(2).getAnswer());
                System.out.println("Would you like more info? say <more information> or <no>");
                userInput = keyboard.nextLine();
                if (!userInput.equalsIgnoreCase("no")) {
                    System.out.println("From webMD:");
                    System.out.println(qnAs.get(7).getAnswer());
                }
                //keyword = "Common scabies symptoms include intense itching and a skin rash. Scabies can occur anywhere on the body but are more common on the following parts of the body:";
            }
            else if (userInput.contains("who") | userInput.contains("Who")| userInput.contains("risk") | userInput.contains("Risk")) {
                System.out.println(qnAs.get(3).getAnswer());
                System.out.println("Would you like more info? say <more information> or <no>");
                userInput = keyboard.nextLine();
                if (!userInput.equalsIgnoreCase("no")) {
                    System.out.println("From webMD:");
                    System.out.println(qnAs.get(16).getAnswer());
                }
            }
            else if (userInput.contains("travel") ) {
                System.out.println(qnAs.get(4).getAnswer());
            }
            else if (userInput.contains("treat") | userInput.contains("cure") ) {
                System.out.println(qnAs.get(22).getAnswer());
                System.out.println(qnAs.get(23).getAnswer());
                System.out.println(qnAs.get(24).getAnswer());
                System.out.println(qnAs.get(25).getAnswer());
                System.out.println(qnAs.get(26).getAnswer());

            }
            else if (userInput.contains("diag") ) {
                System.out.println(qnAs.get(21).getAnswer());
            }
            else if (userInput.contains("mpli") ) {
                System.out.println(qnAs.get(20).getAnswer());
            }
            else if (userInput.contains("typ") ) {
                System.out.println(qnAs.get(19).getAnswer());
            }
            else if (userInput.contains("hi") | userInput.contains("hello")) {
                System.out.println("Hello! What questions do you  have about scabies?");
            }
            else {
                System.out.println("I can't help you with that yet. Try asking something different, or in a different way.\nPlease check that you havent misspelled your question.");
            }
            
        /* System.out.println("Searching for " + keyword);
        for (int i =0; i<qnAs.size(); i++) {
                System.out.println("searching record " + i);
                if (qnAs.get(i).getQuestion().contains(keyword)) {
                    System.out.println(qnAs.get(i).getQuestion());
                    System.out.println(qnAs.get(i).getAnswer());
                    break;
                }
                
            }
            */
            
            userInput = keyboard.nextLine();
        }

       System.exit(0);
        

        /* 
        System.out.println("POOOOOOOOOOOP");
        System.out.println(qnAs.get(2).getAnswer());

        System.out.println("trying fancy way");
        System.out.println(qnAs.));
        */
   } 
    
}
