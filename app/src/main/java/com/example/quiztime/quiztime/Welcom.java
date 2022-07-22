package com.example.quiztime.quiztime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Welcom extends AppCompatActivity{
    ImageView im,point;


    Animation an,anp;
    private  static int SPLASH_TIME_OUT=3000;
    ImageView imwelcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        im = (ImageView)findViewById(R.id.iconwelcom);
        point =(ImageView)findViewById(R.id.piont);
        an= AnimationUtils.loadAnimation(this,R.anim.feed);
        anp= AnimationUtils.loadAnimation(this,R.anim.point);
        im.setAnimation(an);
        point.setAnimation(an);

        new Handler().postDelayed(new Runnable() {
            @Override


            public void run()
            {

                Intent home=new Intent(Welcom.this,Login.class);
                startActivity(home);

                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
