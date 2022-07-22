package com.example.quiztime.quiztime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    // ID icone == imicon
    //ID edit text email == emaill
    // ID edit text password == passl
    //ID Button login = login -->
    // ID Button Regester Hier = regesterl

    //declaration CardView
    android.support.v7.widget.CardView c1;

    TextView useremail,password;
    Button login,Regester;
    Animation ani;
    ImageView icone;

    private FirebaseAuth mAuth;
    private DatabaseReference mDataBase;
    private ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        //EditText
        useremail=(TextView)findViewById(R.id.emaill);
        password=(TextView)findViewById(R.id.passl);

        //Button
        login=(Button)findViewById(R.id.login);
        Regester=(Button)findViewById(R.id.regesterl);

        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference().child("users");

        //keeping the user logged in
      /*  FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Intent menuIntent = new Intent(Login.this,GameActivity.class);
            startActivity(menuIntent);
        }else{
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }*/

        //cardView
        c1=(CardView)findViewById(R.id.c1);
        //ImageView
        icone=(ImageView) findViewById(R.id.imicon);
        //animation Icon
        ani= AnimationUtils.loadAnimation(this,R.anim.feed);
        icone.setAnimation(ani);
        Regester.setAnimation(ani);
        c1.setAnimation(ani);
        //progress dialog
        mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");

    }

        public void signinButtonClicked(View view){
            mProgress.show();
            final String email = useremail.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass)){
                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            checkUserExist();
                            Toast.makeText(Login.this, "You are in the game now", Toast.LENGTH_SHORT).show();
                        }else{
                            mProgress.dismiss();
                            Toast.makeText(Login.this, "Your Password or Your Email are not correct !", Toast.LENGTH_SHORT).show();
                            useremail.setText("");
                            password.setText("");
                        }
                    }
                });
            }

            }

    public void checkUserExist() {
        final String userid = mAuth.getCurrentUser().getUid();
        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(userid)){
                    mProgress.dismiss();
                    Intent menuIntent = new Intent(Login.this,GameActivity.class);
                    startActivity(menuIntent);
                }else{
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void startsignup(View view) {
        Intent signup = new Intent(Login.this,signup.class);
        startActivity(signup);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
