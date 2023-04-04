/**
 * Sets up Question and Answer objects from input files
 * @author Rae Jones
 */
public class QnA {
    private String question;
    private String answer;
    private String source;

    /**
     * constructor for my QnA object
     * @param question the content of the question
     * @param answer the content of the answer
     * @param source source of info
     */
    public QnA(String question, String answer, String source) {
        this.question = question;
        this.answer = answer;
        this.source = source;

    }

    /**
     * constructor for my QnA object that doesnt require all info to be known beforehand
     * @param question the content of the question
     */
    public QnA(String question) {
        this.question = question;
        this.answer = "";
    }

    /**
     * QnA that sets neither question nor answer
     */
    public QnA() {
        this.question = "";
        this.answer = "";
    }

    /**
     * appends the current answer
     * @param answer content of question's answer
     */
    public void addToAnswer(String answer) {
        //this.source = source;
        this.answer = this.answer + answer + "\n";
    }

    /**
     * sets the question & source in a QnA
     * @param question content of question
     * @param source info's source
     */
    public void setQuestion(String question,  String source) {
        this.question = question;
        this.source = source;
    }

    /**
     * retrieves question from QnA
     * @return question
     */
    public String getQuestion() {
        return this.question;
    }
    
    /**
     * retrieves answer from QnA
     * @return answer
     */
    public String getAnswer() {
        return this.answer + this.source;
    }


    /**
     * prints QnA object contents
     */
    public void print() {
        System.out.println(this.question + "\n" + this.answer );
    }

    /**
     * returns answer as a string
     */
    public String toString() {
        return this.answer + "\n";
    }
}