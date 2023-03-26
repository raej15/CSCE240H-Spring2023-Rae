/**
 * Sets up Question and Answer objects from input files
 * @author Rae Jones
 */
/*public class QnA {
    private String question;
    private String answer;

    public QnA(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public QnA(String question) {
        this.question = question;
        this.answer = "";
    }
    public QnA() {
        this.question = "";
        this.answer = "";
    }

    public void addToAnswer(String answer) {
        this.answer = this.answer + answer + "\n";
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
    
    public String getAnswer() {
        return this.answer;
    }

    public void print() {
        System.out.println(this.question + "\n" + this.answer );
    }

    public String toString() {
        return this.answer + "\n";
    }
}