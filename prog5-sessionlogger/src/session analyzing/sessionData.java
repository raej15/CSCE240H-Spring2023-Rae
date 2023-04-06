import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Credit: https://stackoverflow.com/questions/18009416/how-to-count-total-rows-in-csv-using-java for sessionCounter method help
 * @author Rae Jones
 */
public class sessionData {

    /**
     * checks if user's chat pick exists
     * @param chatNum number of chat user wants info on
     * @return true or false
     */
    public static boolean checkSessionValid(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;

            while((line = br.readLine()) != null)
            {
                String[] cols = line.split(",");
                
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error has occurred.");
        }

        return false;
    }

    /**
     * counts the num of chat logs that there are
     * @return returns number of chat logs on record
     */
    public static int sessionCounter() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String input;
            int count = -1;
            while((input = bufferedReader.readLine()) != null)
            {
                count++;
            }
    
            bufferedReader.close();
            return count;
            
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
        
    }

    /**
     * gets num of seconds the program has run over all logged sessions
     * @return total duration of all logged runs in seconds
     */
    public static double totalDuration() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            double duration = 0;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");

                if(!cols[4].equals("time_taken")) {

                    duration += Double.parseDouble(cols[4]);
                }

            }

            br.close();
            return duration;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    /**
     * finds total num of user utterances in CSV file
     * @return total num of user utterances
     */
    public static int totalUserUtterances() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            int numUser = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                
                if(!cols[4].equals("time_taken")) {
                    
                    numUser += Integer.parseInt(cols[2]);
                }

            }
            br.close();
            return numUser;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }
    /**
     * finds total num of system utterances in CSV file
     * @return total num of system utterances
     */
    public static int totalSystemUtterances() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            int numSystem = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                if(!cols[4].equals("time_taken")) {
                    numSystem += Integer.parseInt(cols[3]);
                }
            }

            br.close();
            return numSystem;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    /**
     * finds num of system utterances for a selected chat in CSV file
     * @param chatNum serial num of requested chat
     * @return num of system utterances for the selected chat
     */
    public static int systemUtterances(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            int numSystem = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                // using comma to split
                String[] cols = line.split(",");

                //eliminating header row from consideration
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                        //getting correct chat's data
                        numSystem += Integer.parseInt(cols[3]);
                    }
                }
            }
            br.close();
            return numSystem;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    /**
     * finds num of user utterances for a selected chat in CSV file
     * @param chatNum serial num of requested chat
     * @return num of user utterances for the selected chat
     */
    public static int userUtterances(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            int numLine = 0;
            String line;
            int numUser = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
 
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                
                        numUser += Integer.parseInt(cols[2]);

                    }
                }
            }
            br.close();
            return numUser;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }


    /**
     * finds duration of a selected chat in CSV file
     * @param chatNum serial num of requested chat
     * @return duration of the selected chat (secs)
     */
    public static double sessionDuration(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            double duration = 0;
            //int numLine = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
            
                String[] cols = line.split(",");
                
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {

                        duration += Double.parseDouble(cols[4]);
                    }
                }
             
            }
            br.close();
            return duration;

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    /**
     * finds file name of requested chat; runs showChat
     * @param chatNum serial num of requested chat
     */
    public static void sessionFileName(int chatNum) {
        String fileName = "";
        //finding correct file name
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            int numLine = 0;
            String line;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                     
                        fileName = cols[1];
                    }
                }
            }
            br.close();
            showChat(fileName);

        } catch (Exception e) {
            System.out.println("An error has occurred.");
        }
    }

    /**
     * returns log content for selected file
     * @param fileName file name of the selected chat log
     */
    public static void showChat(String fileName) {
        //retrieving file contents
        try (BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/" + fileName))) {

            String strCurrentLine;
         
            while ((strCurrentLine = br.readLine()) != null) {
             System.out.println(strCurrentLine);
            }
         
            br.close();
           } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Chat contents not available. Please check that file has not been deleted.");


           }    
    }

    /**
     * summary of all known data across all logs
     * @return a string giving all availiable data over all sessions
     */
    public static String totalSummary() {
        return "There are " + sessionCounter() + " chats to date with user asking " + totalUserUtterances() + " times and system responding " + totalSystemUtterances() + " times. Total duration is " + totalDuration() + " seconds.";
    }

    /**
     * summary of all known data for selected log
     * @param chatNum serial num of requested chat
     * @return a string giving all availiable data for the session
     */
    public static String sessionSummary(int chatNum) {
        return "Chat " + chatNum + " has user asking " + userUtterances(chatNum) + " times and system responding " + systemUtterances(chatNum) + " times. Total duration is " + sessionDuration(chatNum) + " seconds.";
    }
}
