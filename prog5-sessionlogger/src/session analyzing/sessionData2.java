import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
/**
 * Credit: https://stackoverflow.com/questions/18009416/how-to-count-total-rows-in-csv-using-java for sessionCounter method help
 * @author Rae Jones
 */
public class sessionData2 {

    public static String loadCSV() {
        String csvContent = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;

            while((line = br.readLine()) != null)
            {
                csvContent += line + "\n";
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
        }
        System.out.println(csvContent);
        return csvContent;
    }
    //fixed for S.No
    public static boolean checkSessionValid(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;

            while((line = br.readLine()) != null)
            {
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum) {
                        //System.out.println("not header");
                        //System.out.println(cols[0]);
                        //duration += Double.parseDouble(cols[4]);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
        }

        return false;
    }

    public static int sessionCounter() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
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
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
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
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
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
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
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

            return numSystem;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error has occurred.");
            return 0;
        }
    }

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
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[2]);
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                        //System.out.println("not header");
                        //System.out.println(cols[4]);
                        numUser += Integer.parseInt(cols[2]);

                    }
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


    //fixed to rely on S.No
    public static double sessionDuration(int chatNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            String line;
            double duration = 0;
            //int numLine = 0;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                //numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                        //System.out.println("not header");
                        //System.out.println(cols[4]);
                        duration += Double.parseDouble(cols[4]);
                    }
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
            BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_statistics.csv"));
            int numLine = 0;
            String line;
            chatNum+=1;
            while ((line = br.readLine()) != null) {
                numLine++;
                // use comma as separator
                String[] cols = line.split(",");
                //duration += Long.parseLong(cols[4]);
                //System.out.println("Column 5=" + cols[2]);
                if(!cols[4].equals("time_taken")) {
                    if(Integer.parseInt(cols[0]) == chatNum-1) {
                        //System.out.println("not header");
                        //System.out.println(cols[4]);
                        fileName = cols[1];
                    }
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

    //fixed for S.No
    public static void showChat(String fileName) {
        //retrieving file contents
        try (BufferedReader br = new BufferedReader(new FileReader("prog5-sessionlogger/data/chat_sessions/" + fileName))) {

            String strCurrentLine;
         
            while ((strCurrentLine = br.readLine()) != null) {
             System.out.println(strCurrentLine);
            }
         
           } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Chat contents not available. Please check that file has not been deleted.");


           }    
    }

    public static String totalSummary() {
        return "There are " + sessionCounter() + " chats to date with user asking " + totalUserUtterances() + " times and system responding " + totalSystemUtterances() + " times. Total duration is " + totalDuration() + " seconds.";
    }

    public static String sessionSummary(int chatNum) {
        return "Chat " + chatNum + " has user asking " + userUtterances(chatNum) + " times and system responding " + systemUtterances(chatNum) + " times. Total duration is " + sessionDuration(chatNum) + " seconds.";
    }

    public static void main(String[] args) { 
        loadCSV();
    }
}
