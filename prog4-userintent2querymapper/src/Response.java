import java.util.ArrayList;

public class Response {
    /*
    public static void main(String[] args) {
       System.out.println(handleQuerys(" poop"));
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

    public static String chooseQuery(String userInput) {
        
    }

    public static String handleQuerys(String query, ArrayList<QnA> qnAs) {
        String answer = ""; 

        for(int i = 0; i < qnAs.size(); i++) {
            if (qnAs.get(i).getQuestion().contains(query) | qnAs.get(i).getAnswer().contains(query)){
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
