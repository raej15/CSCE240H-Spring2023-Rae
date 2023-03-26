import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Takes in user query and responds with revelvant information
 * Credit: https://stackoverflow.com/questions/7929495/java-finding-the-number-of-word-matches-in-a-given-string for pattern matching in confidence estimation
 * @author Rae Jones
 */
public class Response {

    public static String chosenQuery(String userInput) {
        String[][] knownQueries = {{"What Scabies", "Who Risk", "What can travelers do to prevent scabies", "Type of Scabies", "ympt", "Diag", "Treat", "ompli", "Tell me everything"},{"What is", "Who", "travel", "Crusted", "ymptoms", "Diagnosing", "Treating", "Complications", "everything"}};
        String [][] knownKeywords ={{"cab", "it", "everything", "risk", "who", "travel", "ype", "ympt", "diag", "treat", "ompli"},{"What is", "What is", "everything", "Who",  "Who", "travel", "Crusted", "ymptoms", "Diagnosing", "Treat", "Complications"}};
        String closestQuery = knownKeywords[0][0];
        int highMatchNum = 0;
  

        for (int row = 0; row < knownKeywords.length; row++) {
            for (int col = 0; col < knownKeywords[row].length; col++) {
                if (highMatchNum <= queryConfidence(userInput, knownKeywords[0][col])) {
                    highMatchNum = queryConfidence(userInput, knownKeywords[0][col]);
                    closestQuery = knownKeywords[1][col];
                }
            } 
        }
        if (highMatchNum==0) {
            return "";
        }

        else {
            return closestQuery;
        }

    }

    public static int queryConfidence(String userInput, String knownQuery) {
        String[] uSplit = userInput.split("\\s");
        int totalMatches = 0;
        long percentMatch;
         for ( int i = 0; i < uSplit.length; i++) {
             totalMatches= totalMatches + queryMatch(uSplit[i], knownQuery);
 
         }
         //percentMatch = totalMatches/uSplit.length;
         return totalMatches;
    }

    
    public static int queryMatch(String userInputWord, String knownQuery) {
        String toMatch = userInputWord.toLowerCase();
        int matches = 0;  
        if (toMatch.contains(knownQuery.toLowerCase())) {
            matches++;
        }
        return matches;

    }


    public static String handleQuerys(String userInput, ArrayList<QnA> qnAs) {
        String query = chosenQuery(userInput);
        String answer = ""; 
        if (query == "") {
            return "I do not know this information. Try asking something different, or in a different way.\nPlease check that you havent misspelled your question.";
        }
        else if (query.equals("everything")) {
            for(int i = 0; i < qnAs.size(); i++) {
                answer = answer + "\n" + qnAs.get(i).getQuestion() +  "\n" + qnAs.get(i).getAnswer();
            }

            return answer;
        }
        for(int i = 0; i < qnAs.size(); i++) {
            if (qnAs.get(i).getQuestion().contains(query)){
                answer = answer + "\n" + qnAs.get(i).getAnswer();
            }
        }

        if (answer == "") {
            answer = "I do not know this information. Try asking something different, or in a different way.\nPlease check that you havent misspelled your question.";
        }

        return answer;
    }

    public static String tellMore(String userInput, ArrayList<QnA> qnAs, boolean second) {
        String answer = handleQuerys(userInput, qnAs);
        int indexNextAnswer = answer.indexOf("-\n");

        if (answer.contains("I do not know") | answer.contains("every")) {
            return answer;
        }
        else if (second && (indexNextAnswer + 2 == answer.length())) {
            return "no";
        }
        else if (second) {
          return answer.substring(indexNextAnswer + 3, answer.length());
        }
        else {
            return answer.substring(0,indexNextAnswer + 2);
        }
      
    }

}
