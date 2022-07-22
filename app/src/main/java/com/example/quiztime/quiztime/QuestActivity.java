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

public class QuestActivity extends AppCompatActivity {
    private ImageView img,questimage;
    private TextView score;
    private Button answear1,answear2,answear3,answear4;
    private int scorecat=0;

    Random r;
    int turn = 1;
    List<Questions> listofteams;
 //   ArrayList<Questions> quests = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        getSupportActionBar().hide();
        r = new Random();
        img = (ImageView) findViewById(R.id.img);
        score = (TextView) findViewById(R.id.score);
        questimage = (ImageView)findViewById(R.id.questimage);
        answear1 = (Button)findViewById(R.id.answear1);
        answear2 = (Button)findViewById(R.id.answear2);
        answear3 = (Button)findViewById(R.id.answear3);
        answear4 = (Button)findViewById(R.id.answear4);
        answear4 = (Button)findViewById(R.id.answear4);

        score.setText("0/10");
        listofteams = new ArrayList<>();
        //add all teams and names to the list
        for(int i =0;i<new teamsdatabase().answers.length;i++){
            listofteams.add(new Questions(new teamsdatabase().answers[i],new teamsdatabase().teams[i]));
        }
        //shuffle the teams

        Collections.shuffle(listofteams);

        newQuestion(turn);

        Bundle extras = getIntent().getExtras();
        int img1= extras.getInt("catimage");
        img.setImageResource(img1);


    }


    public void savescore(){

    }

    public void checkanswear1(View view){


    //check the correct answer
        if(answear1.getText().toString().equalsIgnoreCase(listofteams.get(turn -1).getQuestionname())){
            //check if the last question
            scorecat++;
            score.setText(+ scorecat + "/10");
            if(turn<listofteams.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(QuestActivity.this, "you finished the football category Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);

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
            if (answear2.getText().toString().equalsIgnoreCase(listofteams.get(turn - 1).getQuestionname())) {
                scorecat++;
                score.setText(+ scorecat + "/10");
                //check if the last question
                if (turn < listofteams.size()) {
                    turn++;
                    newQuestion(turn);
                } else {
                    if (scorecat == 10) {
                        Toast.makeText(QuestActivity.this, "you finished the football category Try an other one", Toast.LENGTH_SHORT).show();
                        Intent gameplay = new Intent(QuestActivity.this, GameActivity.class);

                        startActivity(gameplay);
                    } else {
                        Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
                        Intent gameplay = new Intent(QuestActivity.this, GameActivity.class);
                        startActivity(gameplay);
                    }
                }
            } else {
                turn++;
                newQuestion(turn);
            }

    }
    public void checkanswear3(View view){


        //check the correct answer
        if(answear3.getText().toString().equalsIgnoreCase(listofteams.get(turn -1).getQuestionname())){
            scorecat++;
            score.setText(+ scorecat + "/10");
            //check if the last question
            if(turn<listofteams.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(QuestActivity.this, "you finished the sport football Try an other one", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
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
        if(answear4.getText().toString().equalsIgnoreCase(listofteams.get(turn -1).getQuestionname())){
            scorecat++;
            score.setText(+ scorecat + "/10");
            //check if the last question
            if(turn<listofteams.size()){
                turn++;
                newQuestion(turn);
            }else{
                if(scorecat==10){
                    Toast.makeText(QuestActivity.this, "you finished the football category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                    startActivity(gameplay);
                }else{
                    Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
                    Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                    startActivity(gameplay);
                }
            }
        }else{
            turn++;
            newQuestion(turn);
        }
    }
public void passquest(View view){
    if(turn<listofteams.size()){
        turn++;
        newQuestion(turn);
    }else{
        if(scorecat==10){
            Toast.makeText(QuestActivity.this, "you finished the sport football try an other one", Toast.LENGTH_SHORT).show();
            Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
            startActivity(gameplay);
        }else{
            Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
            Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
            startActivity(gameplay);
        }
    }
}








    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent game = new Intent(QuestActivity.this,GameActivity.class);
        startActivity(game);
    }

    private void newQuestion(int number){
        if (turn < listofteams.size()) {
            questimage.setImageResource(listofteams.get(number - 1).getQuestionimage());

            int correct_answer = r.nextInt(4) + 1;
            int firstbutton = number - 1;
            int secondbutton;
            int thirdbutton;
            int fourthbutton;
            switch (correct_answer) {
                case 1:
                    answear1.setText(listofteams.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofteams.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofteams.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofteams.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear2.setText(listofteams.get(secondbutton).getQuestionname());
                    answear3.setText(listofteams.get(thirdbutton).getQuestionname());
                    answear4.setText(listofteams.get(fourthbutton).getQuestionname());
                    break;
                case 2:
                    answear2.setText(listofteams.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofteams.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofteams.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofteams.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear1.setText(listofteams.get(secondbutton).getQuestionname());
                    answear3.setText(listofteams.get(thirdbutton).getQuestionname());
                    answear4.setText(listofteams.get(fourthbutton).getQuestionname());
                    break;
                case 3:
                    answear3.setText(listofteams.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofteams.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofteams.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofteams.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear2.setText(listofteams.get(secondbutton).getQuestionname());
                    answear1.setText(listofteams.get(thirdbutton).getQuestionname());
                    answear4.setText(listofteams.get(fourthbutton).getQuestionname());
                    break;
                case 4:
                    answear4.setText(listofteams.get(firstbutton).getQuestionname());
                    do {
                        secondbutton = r.nextInt(listofteams.size());
                    } while (secondbutton == firstbutton);
                    do {
                        thirdbutton = r.nextInt(listofteams.size());
                    } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                    do {
                        fourthbutton = r.nextInt(listofteams.size());
                    }
                    while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);
                    answear2.setText(listofteams.get(secondbutton).getQuestionname());
                    answear3.setText(listofteams.get(thirdbutton).getQuestionname());
                    answear1.setText(listofteams.get(fourthbutton).getQuestionname());
                    break;
            }
        }else{
            if(scorecat==10){
                Toast.makeText(QuestActivity.this, "you finished the football category try an other one", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                startActivity(gameplay);
            }else{
                Toast.makeText(QuestActivity.this, "you need to finish the football category", Toast.LENGTH_SHORT).show();
                Intent gameplay = new Intent(QuestActivity.this,GameActivity.class);
                startActivity(gameplay);
            }
        }
    }
}


