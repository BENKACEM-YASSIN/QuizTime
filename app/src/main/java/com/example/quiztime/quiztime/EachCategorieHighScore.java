package com.example.quiztime.quiztime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EachCategorieHighScore extends AppCompatActivity {

    TextView footballhighscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_categorie_high_score);
        footballhighscore = (TextView) findViewById(R.id.footballhighscore);
        int max=0;
        Bundle extras = getIntent().getExtras();
        int sporthighscore= extras.getInt("footballhighscore");
        if(sporthighscore>max){
            max=sporthighscore;
            footballhighscore.setText("Football's highscore is "+max);
        }

    }
}
