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

public class CelebrityQuestions extends AppCompatActivity {

    private ImageView img,questimage;
    private TextView score;
    private Button answear1,answear2,answear3,answear4;
    private int scorecat=0;

    Random r;
    int turn = 1;
    List<Questions> listofcelebreties;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity_questions);
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
        listofcelebreties = new ArrayList<>();
        for (int i = 0; i < new celebretiesdatabase().answers.length; i++) {
            listofcelebreties.add(new Questions(new celebretiesdatabase().answers[i], new celebretiesdatabase().countries[i]));
        }
        Collections.shuffle(listofcelebreties);

        newQuestion(turn);

    }



    public void checkanswear1(View view){
        //check the correct answer
        if(answear1.getText().toString().equalsIgnoreCase(listofcelebreties.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofcelebreties.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(CelebrityQuestions.this, "you finished the Celebrety category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(CelebrityQuestions.this, "you need to finish the Celebrety category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
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
        if(answear2.getText().toString().equalsIgnoreCase(listofcelebreties.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofcelebreties.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(CelebrityQuestions.this, "you finished the Celebrety category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(CelebrityQuestions.this, "you need to finish the Celebrety category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
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
        if(answear3.getText().toString().equalsIgnoreCase(listofcelebreties.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofcelebreties.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(CelebrityQuestions.this, "you finished the Celebrety category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(CelebrityQuestions.this, "you need to finish the Celebrety category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
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
        if(answear4.getText().toString().equalsIgnoreCase(listofcelebreties.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofcelebreties.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(CelebrityQuestions.this, "you finished the Celebrety category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(CelebrityQuestions.this, "you need to finish the Celebrety category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent game = new Intent(CelebrityQuestions.this,GameActivity.class);
        startActivity(game);
    }

    private void newQuestion(int number){
        if(turn<listofcelebreties.size()){
        questimage.setImageResource(listofcelebreties.get(number - 1).getQuestionimage());

        int correct_answer = r.nextInt(4)+1;
        int firstbutton = number -1 ;
        int secondbutton;
        int thirdbutton;
        int fourthbutton;
        switch (correct_answer){
            case 1 :
                answear1.setText(listofcelebreties.get(firstbutton).getQuestionname());
                do{
                    secondbutton = r.nextInt(listofcelebreties.size());
                }while (secondbutton==firstbutton);
                do{
                    thirdbutton = r.nextInt(listofcelebreties.size());
                }while (thirdbutton==firstbutton || thirdbutton==secondbutton);
                do{
                    fourthbutton = r.nextInt(listofcelebreties.size());
                }while (fourthbutton==firstbutton ||fourthbutton==secondbutton ||fourthbutton==thirdbutton);
                answear2.setText(listofcelebreties.get(secondbutton).getQuestionname());
                answear3.setText(listofcelebreties.get(thirdbutton).getQuestionname());
                answear4.setText(listofcelebreties.get(fourthbutton).getQuestionname());
                break;
            case 2 :
                answear2.setText(listofcelebreties.get(firstbutton).getQuestionname());
                do{
                    secondbutton = r.nextInt(listofcelebreties.size());
                }while (secondbutton==firstbutton);
                do{
                    thirdbutton = r.nextInt(listofcelebreties.size());
                }while (thirdbutton==firstbutton || thirdbutton==secondbutton);
                do{
                    fourthbutton = r.nextInt(listofcelebreties.size());
                }while (fourthbutton==firstbutton ||fourthbutton==secondbutton ||fourthbutton==thirdbutton);
                answear1.setText(listofcelebreties.get(secondbutton).getQuestionname());
                answear3.setText(listofcelebreties.get(thirdbutton).getQuestionname());
                answear4.setText(listofcelebreties.get(fourthbutton).getQuestionname());
                break;
            case 3 :
                answear3.setText(listofcelebreties.get(firstbutton).getQuestionname());
                do{
                    secondbutton = r.nextInt(listofcelebreties.size());
                }while (secondbutton==firstbutton);
                do{
                    thirdbutton = r.nextInt(listofcelebreties.size());
                }while (thirdbutton==firstbutton || thirdbutton==secondbutton);
                do{
                    fourthbutton = r.nextInt(listofcelebreties.size());
                }while (fourthbutton==firstbutton ||fourthbutton==secondbutton ||fourthbutton==thirdbutton);
                answear2.setText(listofcelebreties.get(secondbutton).getQuestionname());
                answear1.setText(listofcelebreties.get(thirdbutton).getQuestionname());
                answear4.setText(listofcelebreties.get(fourthbutton).getQuestionname());
                break;
            case 4 :
                answear4.setText(listofcelebreties.get(firstbutton).getQuestionname());
                do{
                    secondbutton = r.nextInt(listofcelebreties.size());
                }while (secondbutton==firstbutton);
                do{
                    thirdbutton = r.nextInt(listofcelebreties.size());
                }while (thirdbutton==firstbutton || thirdbutton==secondbutton);
                do{
                    fourthbutton = r.nextInt(listofcelebreties.size());
                }while (fourthbutton==firstbutton ||fourthbutton==secondbutton ||fourthbutton==thirdbutton);
                answear2.setText(listofcelebreties.get(secondbutton).getQuestionname());
                answear3.setText(listofcelebreties.get(thirdbutton).getQuestionname());
                answear1.setText(listofcelebreties.get(fourthbutton).getQuestionname());
                break;
        }
    }else{
            if(scorecat==10){
                Toast.makeText(CelebrityQuestions.this, "you finished the Celebrety category Try an other one", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                startActivity(gameplay);
            }else{
                Toast.makeText(CelebrityQuestions.this, "you need to finish the Celebrety category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(CelebrityQuestions.this,GameActivity.class);
                startActivity(gameplay);
            }
        }
    }
}
