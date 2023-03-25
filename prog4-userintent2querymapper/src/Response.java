import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Credit: https://stackoverflow.com/questions/7929495/java-finding-the-number-of-word-matches-in-a-given-string for pattern matching in confidence estimation
 */
public class Response {
    
    /*
    public static void main(String[] args) {
       //System.out.println(handleQuerys(" poop"));
        ArrayList<QnA> qnAs = new ArrayList<QnA>();
        qnAs.addAll(DataLoader.loadCDC());
        qnAs.addAll(DataLoader.loadWebMD());

       String userInput = "who can get it";
       System.out.println(chosenQuery(userInput));
       System.out.println(handleQuerys(userInput, qnAs));



    }
    */
    
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
    //public static String[][] knownQueries = {{"What is Scabies", "Who is at Risk", "What can travelers do to prevent scabies", "Types of Scabies", "Symptoms", "When to call a Doctor", "Scabies Diagnosis", "Scabies Treatment", "Scabies Complications", "Tell me everything"},{"What is", "Who", "travel"}};


    public static String chosenQuery(String userInput) {
        String[][] knownQueries = {{"What is Scabies", "Who is at Risk", "What can travelers do to prevent scabies", "Types of Scabies", "Symptoms", "When to call a Doctor", "Scabies Diagnosis", "Scabies Treatment", "Scabies Complications", "Tell me everything"},{"What is", "Who", "travel"}};
        //int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        String closestQuery = knownQueries[0][0];
        int highMatchNum = 0;
        //String[] uSplit = userInput.split("\\s");
        String[] qSplit;

        for (int row = 0; row < knownQueries.length; row++) {
            for (int col = 0; col < knownQueries[row].length; col++) {
                 //board[row][col] = row * col; 
                //System.out.println(queryConfidence(userInput, knownQueries[0][col]));

                if(highMatchNum < queryConfidence(userInput, knownQueries[0][col])) {
                    highMatchNum = queryConfidence(userInput, knownQueries[0][col]);
                    closestQuery = knownQueries[1][col];
                }
            } 
        }

        //System.out.println(closestQuery);

        //for (int i=0; i < 10; i++) {
         //   System.out.println(queryConfidence(userInput, knownQueries[i][0]));
        //}
        return closestQuery;

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
        String toMatch = "\\b" + userInputWord + "\\b";
        int matches = 0;  
        Matcher matcher = Pattern.compile(toMatch, Pattern.CASE_INSENSITIVE).matcher(knownQuery);
        while (matcher.find()) matches++;
        return matches;

    }


    public static String handleQuerys(/*String query, */ String userInput, ArrayList<QnA> qnAs) {
        String query = chosenQuery(userInput);
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
