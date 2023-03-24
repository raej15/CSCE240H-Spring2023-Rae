import java.util.ArrayList;

public class Response {
    public static void main(String[] args) {
        handleQuerys("pet");
    }
    
    static ArrayList<QnA> qnAs = new ArrayList<QnA>();

    public static void popQNAS() {
        qnAs.addAll(DataLoader.loadCDC());
        qnAs.addAll(DataLoader.loadWebMD());
         //TESTING QNA POPULATION
         /*for(int i = 0; i < qnAs.size(); i++) {   
            System.out.print("\nQUESTION:\n"+ qnAs.get(i).getQuestion()+"\n");
            System.out.print("\nANSWER:\n"+ qnAs.get(i).getAnswer()+"\n");
        } 
        */
    }

    public static void handleQuerys(String query) {
        String answer = null; 
        popQNAS();

        for(int i = 0; i < qnAs.size(); i++) {
            if (qnAs.get(i).getQuestion().contains(query) | qnAs.get(i).getAnswer().contains(query)){
                answer = answer + "\n" + qnAs.get(i).getAnswer();
            }
        }

        System.out.println(answer);
    }



}
