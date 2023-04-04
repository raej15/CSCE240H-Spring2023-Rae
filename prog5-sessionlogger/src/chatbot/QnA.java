/**
 * Sets up Question and Answer objects from input files
 * @author Rae Jones
 */
public class QnA {
    private String question;
    private String answer;
    private String source;

    public QnA(String question, String answer, String source) {
        this.question = question;
        this.answer = answer;
        this.source = source;

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
        //this.source = source;
        this.answer = this.answer + answer + "\n";
    }

    public void setQuestion(String question,  String source) {
        this.question = question;
        this.source = source;
    }

    public String getQuestion() {
        return this.question;
    }
    
    public String getAnswer() {
        return this.answer + this.source;
    }


    public void print() {
        System.out.println(this.question + "\n" + this.answer );
    }

    public String toString() {
        return this.answer + "\n";
    }
}