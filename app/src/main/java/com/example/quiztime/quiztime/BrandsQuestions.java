package com.example.quiztime.quiztime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BrandsQuestions extends AppCompatActivity {
    private ImageView img,questimage;
    private TextView score;
    private Button answear1,answear2,answear3,answear4;
    private int scorecat=0;

    Random r;
    int turn = 1;
    List<Questions> listofbrands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_questions);
        getSupportActionBar().hide();
        img = (ImageView) findViewById(R.id.img);
        score = (TextView) findViewById(R.id.score);
        Bundle extras = getIntent().getExtras();
        int img1 = extras.getInt("catimage");
        img.setImageResource(img1);
        r = new Random();

        questimage = (ImageView) findViewById(R.id.questimage);
        answear1 = (Button) findViewById(R.id.answear1);
        answear2 = (Button) findViewById(R.id.answear2);
        answear3 = (Button) findViewById(R.id.answear3);
        answear4 = (Button) findViewById(R.id.answear4);
        answear4 = (Button) findViewById(R.id.answear4);
        score.setText("0/10");
        listofbrands = new ArrayList<>();
        for (int i = 0; i < new brandsdatabase().answers.length; i++) {
            listofbrands.add(new Questions(new brandsdatabase().answers[i], new brandsdatabase().countries[i]));
        }
        Collections.shuffle(listofbrands);
        newQuestion(turn);
    }


    public void checkanswear1(View view){
        //check the correct answer
        if(answear1.getText().toString().equalsIgnoreCase(listofbrands.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofbrands.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(BrandsQuestions.this, "you finished the Brands category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(BrandsQuestions.this, "you need to finish the Brands category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }

    }

    public void checkanswear2(View view){
        //check the correct answer
        if(answear2.getText().toString().equalsIgnoreCase(listofbrands.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofbrands.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(BrandsQuestions.this, "you finished the Brands category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(BrandsQuestions.this, "you need to finish the Brands category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }

    }
    public void checkanswear3(View view){
        //check the correct answer
        if(answear3.getText().toString().equalsIgnoreCase(listofbrands.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofbrands.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(BrandsQuestions.this, "you finished the Brands category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(BrandsQuestions.this, "you need to finish the Brands category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }

    }

    public void checkanswear4(View view){
        //check the correct answer
        if(answear4.getText().toString().equalsIgnoreCase(listofbrands.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofbrands.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(BrandsQuestions.this, "you finished the Brands category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(BrandsQuestions.this, "you need to finish the Brands category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }

    }

    public void passquest(View view){
        if(turn<listofbrands.size()){
            turn++;
            newQuestion(turn);
        }else{
            if(scorecat==10){
                Toast.makeText(BrandsQuestions.this, "you finished the Brands category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                startActivity(gameplay);
            }else{
                Toast.makeText(BrandsQuestions.this, "you need to finish the Brands category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(BrandsQuestions.this,GameActivity.class);
                startActivity(gameplay);
            }
        }
    }


    private void newQuestion(int number) {
        if (turn < listofbrands.size()) {

            questimage.setImageResource(listofbrands.get(number - 1).getQuestionimage());
            int correct_answer = r.nextInt(4) + 1;
            int firstbutton = number - 1;
            int secondbutton;
            int thirdbutton;
            int fourthbutton;
            switch (correct_answer) {
                case 1:
                    answear1.setText(listofbrands.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofbrands.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofbrands.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofbrands.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);

                    answear2.setText(listofbrands.get(secondbutton).getQuestionname());
                    answear3.setText(listofbrands.get(thirdbutton).getQuestionname());
                    answear4.setText(listofbrands.get(fourthbutton).getQuestionname());
                    break;
                case 2:
                    answear2.setText(listofbrands.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofbrands.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofbrands.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofbrands.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear1.setText(listofbrands.get(secondbutton).getQuestionname());
                    answear3.setText(listofbrands.get(thirdbutton).getQuestionname());
                    answear4.setText(listofbrands.get(fourthbutton).getQuestionname());
                    break;
                case 3:
                    answear3.setText(listofbrands.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofbrands.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofbrands.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofbrands.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear2.setText(listofbrands.get(secondbutton).getQuestionname());
                    answear1.setText(listofbrands.get(thirdbutton).getQuestionname());
                    answear4.setText(listofbrands.get(fourthbutton).getQuestionname());
                    break;
                case 4:
                    answear4.setText(listofbrands.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofbrands.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofbrands.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofbrands.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear2.setText(listofbrands.get(secondbutton).getQuestionname());
                    answear3.setText(listofbrands.get(thirdbutton).getQuestionname());
                    answear1.setText(listofbrands.get(fourthbutton).getQuestionname());
                    break;
            }
        } else {
            if (scorecat == 10) {
                Toast.makeText(BrandsQuestions.this, "you finished the Country category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(BrandsQuestions.this, GameActivity.class);
                startActivity(gameplay);
            } else {
                Toast.makeText(BrandsQuestions.this, "you need to finish the Country category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(BrandsQuestions.this, GameActivity.class);
                startActivity(gameplay);
            }
        }

    }




}
