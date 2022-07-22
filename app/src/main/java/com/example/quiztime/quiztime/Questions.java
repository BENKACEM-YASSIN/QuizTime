package com.example.quiztime.quiztime;

/**
 * Created by ProBook 650 G1 on 10/12/2017.
 */

public class Questions {
    private String Questionname;
    private int Questionimage;

    public Questions(String questionname, int questionimage) {
        Questionname = questionname;
        Questionimage = questionimage;
    }

    public String getQuestionname() {
        return Questionname;
    }

    public void setQuestionname(String questionname) {
        Questionname = questionname;
    }

    public int getQuestionimage() {
        return Questionimage;
    }

    public void setQuestionimage(int questionimage) {
        Questionimage = questionimage;
    }
}
