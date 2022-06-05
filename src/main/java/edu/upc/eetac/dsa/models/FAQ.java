package edu.upc.eetac.dsa.models;

public class FAQ {
    private String Question;
    private String Ans;
    public FAQ(){

    }
    public FAQ(String Question, String Ans) {
        this.Question = Question;
        this.Ans = Ans;
    }
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question){this.Question = Question;}

    public String getAns() {
        return Ans;
    }

    public void setAns(String Ans){
        this.Ans = Ans;
    }
}