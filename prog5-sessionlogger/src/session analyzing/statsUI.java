import java.util.Scanner;

/**
 * user interface for getting chatbot statistics
 * @author Rae Jones
 */
public class statsUI {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int userInput = 0;
        int uniqueUserInput = 0;

        while (!(userInput == 3)) {
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nHOME MENU:\n\nWould you like to \n1. get overall summary\n2. look at a specific chat's data\n3. quit");
            userInput = keyboard.nextInt();
            if (userInput == 1) {
                System.out.println(sessionData.totalSummary());
            }
            else if (userInput==2) {
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nEnter the chat # you'd like to see");
                userInput = keyboard.nextInt();
                if (sessionData.checkSessionValid(userInput)) {
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nWould you like to \n1. show chat log\n2. look at chat's summary\n3. quit");
                    uniqueUserInput = keyboard.nextInt();
                    if (uniqueUserInput == 1) {
                        sessionData.sessionFileName(userInput);
                    }
                    else if (uniqueUserInput == 2) {
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChat " + userInput + "'s Session Summary:\n\n" + sessionData.sessionSummary(userInput));
                    }
                    else if (uniqueUserInput == 3) {
                        System.out.println("EXITING PROGRAM");
                        System.exit(0);
                    }
                }
                else {
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nERROR: there are only " + sessionData.sessionCounter() + " chat sessions. Please choose a valid number.");
                }
            }

            else if (userInput==3) {
                System.out.println("EXITING PROGRAM");
                System.exit(0);
            }



        }
    
    }

}

