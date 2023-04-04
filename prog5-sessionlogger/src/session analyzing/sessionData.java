import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Credit: https://stackoverflow.com/questions/18009416/how-to-count-total-rows-in-csv-using-java for sessionCounter method help
 * @author Rae Jones
 */
public class sessionData {

    public static boolean checkSessionValid(int chatNum) {
        int count = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String input;
            while((input = bufferedReader.readLine()) != null)
            {
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
        }

        if (chatNum > count) {
            return false;

        }
        else {
            return true;
        }
    }

    public static int sessionCounter() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String input;
            int count = -1;
            while((input = bufferedReader.readLine()) != null)
            {
                count++;
            }
    
            return count;
            //System.out.println("Count : "+count);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static double totalDuration() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String line;
            double duration = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[4]);
                if(!cols[4].equals("time_taken")) {
                    //System.out.println("not header");
                    //System.out.println(cols[4]);
                    //System.out.println(Double.parseDouble(cols[4]));
                    duration += Double.parseDouble(cols[4]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return duration;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static int totalUserUtterances() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String line;
            int numUser = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[2]);
                if(!cols[4].equals("time_taken")) {
                    //System.out.println("not header");
                    //System.out.println(cols[4]);
                    //System.out.println(Double.parseDouble(cols[4]));
                    numUser += Integer.parseInt(cols[2]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return numUser;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static int totalSystemUtterances() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String line;
            int numSystem = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[3]);
                if(!cols[4].equals("time_taken")) {
                    numSystem += Integer.parseInt(cols[3]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return numSystem;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static int systemUtterances(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            int numLine = 0;
            String line;
            int numSystem = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[3]);
                if(numLine == chatNum) {
                    numSystem += Integer.parseInt(cols[3]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return numSystem;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static int userUtterances(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            int numLine = 0;
            String line;
            int numUser = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[2]);
                if(numLine == chatNum) {
                    numUser += Integer.parseInt(cols[2]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return numUser;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }


    public static double sessionDuration(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            String line;
            double duration = 0;
            int numLine = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[4]);
                if(numLine == chatNum) {
                    //System.out.println("not header");
                    //System.out.println(cols[4]);
                    //System.out.println(Double.parseDouble(cols[4]));
                    duration += Double.parseDouble(cols[4]);
                }

                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            return duration;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

    public static void sessionFileName(int chatNum) {
        String fileName = "";
        //finding correct file name
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/chat_statistics.csv"));
            int numLine = 0;
            String line;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[2]);
                if(numLine == chatNum) {
                    fileName = cols[1];
                }

                //System.out.println(fileName);
                //System.out.println("Coulmn 4= " + cols[2] + " , Column 5=" + cols[4]);
                //System.out.println("mow");
            }

            showChat(fileName);
            //return fileName.trim();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            //return "fail";
        }
    }

    public static String showChat(String fileName) {
        //retrieving file contents
        try (BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/" + fileName))) {

            String strCurrentLine;
         
            while ((strCurrentLine = br.readLine()) != null) {
             System.out.println(strCurrentLine);
            }
         
           } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error has occurred.");


           }
        return "no";
    
    }

    public static String totalSummary() {
        return "There are " + sessionCounter() + " chats to date with user asking " + totalUserUtterances() + " times and system responding " + totalSystemUtterances() + " times. Total duration is " + totalDuration() + " seconds.";
    }

    public static String sessionSummary(int chatNum) {
        return "Chat " + chatNum + " has user asking " + userUtterances(chatNum) + " times and system responding " + systemUtterances(chatNum) + " times. Total duration is " + sessionDuration(chatNum) + " seconds.";
    }

    public static void main(String[] args) {
       
       //System.out.println("numSessions: " + sessionCounter() + "\nDuration: " + totalDuration() + "\nUser Utterances: " + totalUserUtterances() +  "\nSystem Utterances: " + totalSystemUtterances());
       System.out.println(totalSummary());
       System.out.println(sessionSummary(4));
       sessionFileName(5);


    }
}
