import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * loads in data from CDC and WebMD
 * Credit: https://www.w3schools.com/java/java_regex.asp for help with pattern matching
 * @author Rae Jones
 */
public class DataLoader {

    static boolean lastQuestion;
    static int currIndex = -1;
    static String currLine;
    static Pattern pattern = Pattern.compile("^[A-Z]", Pattern.CASE_INSENSITIVE);
    static Matcher matcher;
    static boolean matchFound;

    public static ArrayList<QnA> loadCDC() {
        //Scanner keyboard = new Scanner(System.in);
        //String currLine;
        //Pattern pattern = Pattern.compile("^[A-Z]", Pattern.CASE_INSENSITIVE);
       // Matcher matcher;
        //boolean matchFound;
        ArrayList<QnA> cQnAs = new ArrayList<QnA>();
        QnA wcurrQnA;

        try {

            File cdcData = new File("./prog4-userintent2querymapper/data/cdcOutput.txt");
            Scanner fileReader = new Scanner(cdcData);
            

            while (fileReader.hasNextLine()) {
                currLine = fileReader.nextLine();
                matcher = pattern.matcher(currLine);     
                matchFound = matcher.find();
                wcurrQnA = new QnA();

                if (!(currLine.contains("in original file"))) {
                    if(matchFound) {
                        cQnAs.add(wcurrQnA);
                        currIndex++;

                        cQnAs.get(currIndex).setQuestion(currLine.trim(), "\n^ Source: CDC\n---------------\n");
                    } else {
                        cQnAs.get(currIndex).addToAnswer(currLine.trim());
                    }
                }
            }

            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        }

        //keyboard.close();
        //currIndex = 3;
        return cQnAs;
    }

    public static ArrayList<QnA> loadWebMD() {
        ArrayList<QnA> wQnAs = new ArrayList<QnA>();
        QnA currQnA;
        currIndex = -1;

        try {

            File webMDData = new File("./prog4-userintent2querymapper/data/webMDOutput.txt");
            Scanner fileReader = new Scanner(webMDData);
            

            while (fileReader.hasNextLine()) {
                currLine = fileReader.nextLine();
                matcher = pattern.matcher(currLine);     
                matchFound = matcher.find();
                
                currQnA = new QnA();

                if (!(currLine.contains("in original file"))) {
                    if(matchFound&& !(lastQuestion)) {
                        lastQuestion = true;
                        wQnAs.add(currQnA);
                        currIndex++;

                        wQnAs.get(currIndex).setQuestion(currLine.trim(), "\n^ Source: WebMD\n---------------\n");
                    } else {
                        lastQuestion = false;
                        wQnAs.get(currIndex).addToAnswer(currLine.trim());
                    }
                }
            }
        
            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        }

        return wQnAs;

    }


}
