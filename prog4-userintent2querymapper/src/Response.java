import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Credit: https://stackoverflow.com/questions/7929495/java-finding-the-number-of-word-matches-in-a-given-string for pattern matching in confidence estimation
 */
public class Response {
    
    public static void main(String[] args) {
       //System.out.println(handleQuerys(" poop"));
       String userInput = "what is the disease Scabies";
       System.out.println(queryConfidence(userInput));


    }
    
    
    //static ArrayList<QnA> qnAs = new ArrayList<QnA>();

    /*
    public static ArrayList<QnA> popQNAS() {
        ArrayList<QnA> qnAs = new ArrayList<QnA>();
        qnAs.addAll(DataLoader.loadCDC());
        qnAs.addAll(DataLoader.loadWebMD());
         //TESTING QNA POPULATION
         /*for(int i = 0; i < qnAs.size(); i++) {   
            System.out.print("\nQUESTION:\n"+ qnAs.get(i).getQuestion()+"\n");
            System.out.print("\nANSWER:\n"+ qnAs.get(i).getAnswer()+"\n");
        } 
        
        return qnAs;
    }

    */
    public static String[][] knownQueries = {{"What is Scabies", "Who is at Risk", "What can travelers do to prevent scabies", "Types of Scabies", "Symptoms", "When to call a Doctor", "Scabies Diagnosis", "Scabies Treatment", "Scabies Complications", "Tell me everything"},{"What is", "Who", "travel"}};


    public static String chosenQuery(String userInput, ArrayList<QnA> qnAs) {
        //int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        String closestQuery;
        int matchNum;
        //String[] uSplit = userInput.split("\\s");
        String[] qSplit;

    }

    public static int queryConfidence(String userInput) {
        String[] uSplit = userInput.split("\\s");
        int totalMatches = 0;
         for ( int i = 0; i < uSplit.length; i++) {
             totalMatches= totalMatches + queryMatch(uSplit[i], "What is Scabies");
 
         }
         return totalMatches;
    }

    public static int queryMatch(String userInputWord, String knownQuery) {
        String toMatch = "\\b" + userInputWord + "\\b";
        int matches = 0;  
        Matcher matcher = Pattern.compile(toMatch, Pattern.CASE_INSENSITIVE).matcher(knownQuery);
        while (matcher.find()) matches++;
        return matches;

    }


    public static String handleQuerys(String query, ArrayList<QnA> qnAs) {
        String answer = ""; 

        for(int i = 0; i < qnAs.size(); i++) {
            if (qnAs.get(i).getQuestion().contains(query) /* | qnAs.get(i).getAnswer().contains(query)*/){
                answer = answer + "\n" + qnAs.get(i).getAnswer();
            }
        }

        if (answer == "") {
            answer = "I do not know this information. Try asking something different, or in a different way.\nPlease check that you havent misspelled your question.";
        }

        return "\nChatbot:\n" + answer;
    }

    /* 
    public static void printResponse(String query) {
        String answer = handleQuerys(query);
        System.out.print("\nChatbot:\n");




    }

    */



}
