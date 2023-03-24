package oldCode;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataLoader;
import QnA;

import java.util.ArrayList;

/**
 * takes input files and answers questions based on them
 * Credit: https://www.w3schools.com/java/java_regex.asp for help with pattern matching
 * Credit: Used a significant amount of my code from prog2-processor
 * @author Rae Jones
 */
public class oldDriver {
   public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        ArrayList<QnA> qnAs = new ArrayList<QnA>();
        qnAs.addAll(DataLoader.loadCDC());
        qnAs.addAll(DataLoader.loadWebMD());

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What disease are you looking for information about? (input Scabies)\n");
        if (keyboard.nextLine().equalsIgnoreCase("scabies")) {
                
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What questions do you have about scabies?\nEnter (q)uit to exit chat");
            String userInput = keyboard.nextLine();

            while (!userInput.equalsIgnoreCase("q") & !userInput.equalsIgnoreCase("quit")) {
                System.out.print("\nChatbot:\n");

                    if (userInput.contains("symptom")) {
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
                    else if (userInput.contains("every") ) {
                        for(int i = 0; i < qnAs.size()-7; i++) {
                            System.out.println(qnAs.get(i).getQuestion());
                            System.out.println(qnAs.get(i).getAnswer());
                        }
                    }
                    else if (userInput.contains("accin") ) {
                        System.out.println(qnAs.get(4).getAnswer());
                    }
                    
                    else if (userInput.contains("cab") | userInput.contains("isease") | userInput.contains("it") ) {
                        System.out.println(qnAs.get(1).getAnswer());
                        System.out.println("Would you like more info? say <more information> or <no>");
                        userInput = keyboard.nextLine();
                        if (!userInput.equalsIgnoreCase("no")) {
                            System.out.println("\nChatbot:\nFrom webMD:");
                            System.out.println(qnAs.get(5).getAnswer());
                        }
                    }
                    
                    else if (userInput.contains("eather")) {
                        System.out.println("The weather is ok. What questions do you  have about scabies?");
                    }
                    else if (userInput.contains("hi") | userInput.contains("ello")) {
                        System.out.println("Hello! What questions do you  have about scabies?");
                    }
                    else {
                        System.out.println("I do not know this information. Try asking something different, or in a different way.\nPlease check that you havent misspelled your question.");
                    }

                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                
                userInput = keyboard.nextLine();
            }
        } 
        else {
            System.out.println("I do not know this information. Try asking about scabies next time. \nEXITING PROGRAM");
            System.exit(0);
        }
        
        System.out.println("Goodbye!\nEXITING PROGRAM");
        System.exit(0);
        keyboard.close();
   } 
   
}