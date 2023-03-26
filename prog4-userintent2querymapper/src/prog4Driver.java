import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * takes input files and answers questions based on them
 * Credit: https://www.w3schools.com/java/java_regex.asp for help with pattern matching
 * Credit: Used a significant amount of my code from prog2-processor
 * @author Rae Jones
 */
public class prog4Driver {
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
                
               if (Response.tellMore(userInput, qnAs, true).equals("no") | Response.tellMore(userInput, qnAs, true).contains("I do not know")) {
                    System.out.println("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                    userInput = keyboard.nextLine();
               }

               else {
                System.out.println("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: Would you like more information?");
                if (!(keyboard.nextLine().equalsIgnoreCase("no"))) {
                    System.out.println("\nChatbot:\n\n" + Response.tellMore(userInput, qnAs, true));
                }
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                
                userInput = keyboard.nextLine();
               }

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