import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


/**
 * takes input from user and answers questions based on it
 * credit: https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program for runtime formatting help
 * @author Rae Jones
 */
public class prog5Driver {

    public static String getLogDate() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        return timeStamp;
     }

   public static void main(String[] args) {
        //get start runtime
        long startProg = System.currentTimeMillis();

        Scanner keyboard = new Scanner(System.in);
        ArrayList<QnA> qnAs = new ArrayList<QnA>();
        qnAs.addAll(DataLoader.loadCDC());
        qnAs.addAll(DataLoader.loadWebMD());
        String logFileName = getLogDate() + ".txt";
        int userUtterance = 0;
        int systemUtterance = 0;
        String uniqueUserInput;

        try {
            FileWriter myWriter = new FileWriter("prog5-sessionlogger/data/chat_sessions/" + logFileName);
            FileWriter statWriter = new FileWriter("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv", true);
            myWriter.write(getLogDate() + ":Begin User Session");
            //System.out.println("Successfully wrote to the file.");
         
        


        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What disease are you looking for information about? (input Scabies)\n");
        myWriter.write("\n" + getLogDate() + ":System Output:" + "\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What disease are you looking for information about? (input Scabies)\n");
        systemUtterance++;
        uniqueUserInput = keyboard.nextLine();
        myWriter.write("\n" + getLogDate() + ":User Input:" + uniqueUserInput);
        if (uniqueUserInput.equalsIgnoreCase("scabies")) {
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What questions do you have about scabies?\nEnter (q)uit to exit chat");
            myWriter.write("\n" + getLogDate() + ":System Output:" + "\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What questions do you have about scabies?\nEnter (q)uit to exit chat");
            String userInput = keyboard.nextLine();
            myWriter.write("\n" + getLogDate() + ":User Input:" + userInput);
            systemUtterance++;
            userUtterance++;


            while (!userInput.equalsIgnoreCase("q") & !userInput.equalsIgnoreCase("quit")) {
                
               if (Response.tellMore(userInput, qnAs, true).equals("no")) {
                    System.out.println("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                    myWriter.write("\n" + getLogDate() + ":System Output:" + "\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                    systemUtterance++;
                    //writing
                    //myWriter.write("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                    myWriter.write("\n" + getLogDate() + ":System Output:" +"\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                    userInput = keyboard.nextLine();
                    myWriter.write("\n" + getLogDate() + ":User Input:" + userInput);
                    userUtterance++;
                    systemUtterance++;
               }
               else if (Response.tellMore(userInput, qnAs, true).contains("ONLY")) {
                String response = Response.tellMore(userInput, qnAs, false);
                System.out.println("\nChatbot:\n" + response.substring(4, response.length()));
                myWriter.write("\n" + getLogDate() + ":System Output:" +"\nChatbot:\n" + response.substring(4, response.length()));
                systemUtterance++;
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                myWriter.write("\n" + getLogDate() + ":System Output:" +"\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                userInput = keyboard.nextLine();
                myWriter.write("\n" + getLogDate() + ":User Input:" + userInput);
                userUtterance++;
                systemUtterance++;

                }
               else {
                System.out.println("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                myWriter.write("\n" + getLogDate() + ":System Output:" +"\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                systemUtterance++;
                //wrting
                //myWriter.write("\nChatbot:\n" + Response.tellMore(userInput, qnAs, false));
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: Would you like more information?");
                myWriter.write("\n" + getLogDate() + ":System Output:" +"\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: Would you like more information?");
                systemUtterance++;
                uniqueUserInput = keyboard.nextLine();
                myWriter.write("\n" + getLogDate() + ":User Input:" + uniqueUserInput); //fix later
                userUtterance++;
                if (!(uniqueUserInput.equalsIgnoreCase("no"))) {
                    //myWriter.write("\n" + getLogDate() + ":User Input:" + uniqueUserInput); //fix later

                    System.out.println("\nChatbot:\n\n" + Response.tellMore(userInput, qnAs, true));
                    myWriter.write("\n" + getLogDate() + ":System Output:" +"\nChatbot:\n\n" + Response.tellMore(userInput, qnAs, true));
                    systemUtterance++;
                }

                //myWriter.write("\n" + getLogDate() + ":User Input:" + uniqueUserInput); //fix later

                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                myWriter.write("\n" + getLogDate() + ":System Output:" + "\n- - - - - - - - - - - - - - - - - - - - - -\n\nChatbot: What other questions do you have about scabies?\nEnter (q)uit to exit chat");
                systemUtterance++;
                
                userInput = keyboard.nextLine();
                myWriter.write("\n" + getLogDate() + ":User Input:" + userInput);
                userUtterance++;

               }

            }
        } 
        else {
            System.out.println("I do not know this information. Try asking about scabies next time. \nEXITING PROGRAM");
            myWriter.write("\n" + getLogDate() + ":System Output:" + "I do not know this information. Try asking about scabies next time. \nEXITING PROGRAM");
            userUtterance++;
            systemUtterance++;
            long endProg = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            //System.out.print("Execution time is " + formatter.format((endProg - startProg) / 1000d) + " seconds");
                myWriter.write("\nLog Over\n");
                statWriter.write("ADD NUM," +logFileName + "," + userUtterance + "," + systemUtterance + ","+ formatter.format((endProg - startProg) / 1000d) + "\n");
                myWriter.close();
                statWriter.close();
                System.exit(0);

        }
        userUtterance++;
        systemUtterance++;
        System.out.println("Goodbye!\nEXITING PROGRAM");
        keyboard.close();
        long endProg = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        //System.out.print("Execution time is " + formatter.format((endProg - startProg) / 1000d) + " seconds");


       
            //myWriter.write("\nLog Over\n");
            statWriter.write("ADD NUM," +logFileName + "," + userUtterance + "," + systemUtterance + ","+ formatter.format((endProg - startProg) / 1000d) + "\n");
            myWriter.close();
            statWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          System.exit(0);
   } 
   
}