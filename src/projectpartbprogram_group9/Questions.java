package projectpartbprogram_group9;

public class Questions {

    private int type;
    private char answer; // the official answer
    private char userAnswer; // the answer the user selected
    private String questions;
    private String choices[] = new String[4];
    private String quesPic;
    private boolean selected[] = new boolean[4];

    public Questions(int t, char a, String tq, String c[], String qp) {
        type = t;
        answer = a;
        questions = tq;
        choices = c.clone();
        quesPic = qp;
        for (int i = 1; i < 4; i++) {
            selected[i] = false;
        }
    }

    public int getType() {
        return type;
    }

    public String getQuestions() {
        return questions;
    }

    public String getQuesPic() {
        return quesPic;
    }

    public String getChoice(int no) {
        return choices[no];
    }

    public boolean getSelected(int no) {
        return selected[no];
    }

    public void setSelected(int no, boolean status) {
        selected[no] = status;
    }

    public char getAnswer() {
        return this.answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public char getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(char userAnswer) {
        this.userAnswer = userAnswer;
    }

}