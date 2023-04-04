import java.util.Scanner;

/**
 * user interface for getting chatbot statistics
 * @author Rae Jones
 */
public class statsUI {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int userInput;
        int uniqueUserInput;

        System.out.println("Would you like to \n1. get overall summary\n2. look at a specific chat's data");
        userInput = keyboard.nextInt();
        if (userInput == 1) {
            System.out.println(sessionData.totalSummary());
        }
        else if (userInput==2) {
            System.out.println("Enter the chat # you'd like to see");
            userInput = keyboard.nextInt();
            if (sessionData.checkSessionValid(userInput)) {
                System.out.println("Would you like to \n1. show chat log\n2. look at chat's summary");
                uniqueUserInput = keyboard.nextInt();
                if (uniqueUserInput == 1) {
                    sessionData.sessionFileName(userInput);
                }
                else if (uniqueUserInput == 2) {
                    sessionData.sessionSummary(userInput);
                }
            }
            else {
                System.out.println("ERROR: there are only " + sessionData.sessionCounter() + " chat sessions. Please choose a valid number.");
            }
        }

    }
    
}
