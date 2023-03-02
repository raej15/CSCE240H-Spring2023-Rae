
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * takes input files and answers questions based on them
 * Credit: https://www.w3schools.com/java/java_regex.asp for help with pattern matching
 * @author Rae Jones
 */
public class prog3Driver {
   public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
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
                currLine = fileReader.nextLine();
                matcher = pattern.matcher(currLine);     
                matchFound = matcher.find();
                wcurrQnA = new QnA();

                if(matchFound) {
                    qnAs.add(wcurrQnA);
                    currIndex++;

                    qnAs.get(currIndex).setQuestion(currLine.trim());
                } else {
                    qnAs.get(currIndex).addToAnswer(currLine.trim());
                }
            
            }

            fileReader.close();
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
                currLine = fileReader.nextLine();
                matcher = pattern.matcher(currLine);     
                matchFound = matcher.find();
                
                currQnA = new QnA();

                if(matchFound) {
                    qnAs.add(currQnA);
                    currIndex++;

                    qnAs.get(currIndex).setQuestion(currLine.trim());
                } else {
                    qnAs.get(currIndex).addToAnswer(currLine.trim());
                }
            
            }
        
            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        }
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What disease are you looking for information about? (input Scabies)");
        if (keyboard.nextLine().equalsIgnoreCase("scabies")) {
                
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What questions do you have about scabies?\nEnter (q)uit to exit chat");
            String userInput = keyboard.nextLine();

            while (!userInput.equalsIgnoreCase("q") & !userInput.equalsIgnoreCase("quit")) {
                System.out.print("\nChatbot:\n");

                if(userInput.contains("What is scabies") | userInput.contains("what is scabies")) {
                    System.out.println(qnAs.get(1).getAnswer());
                    System.out.println("Would you like more info? say <more information> or <no>");
                    userInput = keyboard.nextLine();
                    if (!userInput.equalsIgnoreCase("no")) {
                    System.out.println("\nChatbot:\nFrom webMD:");
                    System.out.println(qnAs.get(5).getAnswer());
                    }
                    }

                    else if (userInput.contains("symptom")) {
                        System.out.println(qnAs.get(2).getQuestion());
                        System.out.println(qnAs.get(2).getAnswer());
                        System.out.println("Would you like more info? say <more information> or <no>");
                        userInput = keyboard.nextLine();
                        if (!userInput.equalsIgnoreCase("no")) {
                            System.out.println("Chatbot:\nFrom webMD:");
                            System.out.println(qnAs.get(7).getAnswer());
                        }
                    }
                    else if (userInput.contains("who") | userInput.contains("Who")| userInput.contains("risk") | userInput.contains("Risk")) {
                        System.out.println(qnAs.get(3).getAnswer());
                        System.out.println("Would you like more info? say <more information> or <no>");
                        userInput = keyboard.nextLine();
                        if (!userInput.equalsIgnoreCase("no")) {
                            System.out.println("\nChatbot:\nFrom webMD:");
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

                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                
                userInput = keyboard.nextLine();
            }
        } 
        else {
            System.out.println("I do not have any information about that. Try asking about scabies next times. \nEXITING PROGRAM");
            System.exit(0);
        }
        
        System.out.println("Goodbye!\nEXITING PROGRAM");
        System.exit(0);
        keyboard.close();
   } 
   
}