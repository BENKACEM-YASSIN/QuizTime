package com.example.quiztime.quiztime;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    //ID icone == signtext
    //ID edit text email == emails
    // ID edit text firstnam == fnams
    // ID Edit Text name = names
    // ID Edit Text password = passwords
    // ID Button signup = buttonsign

    //declaration CardView
    android.support.v7.widget.CardView c2;

    EditText email,firstname,name,password;
    Button buttonsign;
    TextView t1;
    Animation an;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        //EditText
        email=(EditText) findViewById(R.id.emails);
        firstname=(EditText) findViewById(R.id.fnams);
        name=(EditText) findViewById(R.id.names);
        password=(EditText) findViewById(R.id.passwords);

        //Button
        buttonsign=(Button) findViewById(R.id.buttonsign);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        //cardView
        c2=(CardView)findViewById(R.id.c2);
        //animation
        an= AnimationUtils.loadAnimation(this,R.anim.feed);
       // t1.setAnimation(an);
        buttonsign.setAnimation(an);
        c2.setAnimation(an);
        //TextView
        t1=(TextView)findViewById(R.id.signtext);
        Typeface f1= Typeface.createFromAsset(getAssets(),"font/rb.ttf");
        t1.setTypeface(f1);

    }


    public void startsignup(View view){
        final String email_text = email.getText().toString().trim();
        final String name_text = name.getText().toString().trim();
        final String firstname_text = firstname.getText().toString().trim();
        final String pass_text = password.getText().toString().trim();
        if(!TextUtils.isEmpty(email_text) || !TextUtils.isEmpty(pass_text) || !TextUtils.isEmpty(name_text)|| !TextUtils.isEmpty(firstname_text)){
            mAuth.createUserWithEmailAndPassword(email_text,pass_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        String userid = mAuth.getCurrentUser().getUid();
                        DatabaseReference currentuser = mDatabase.child(userid);
                        Toast.makeText(signup.this, "You're Signed up now !", Toast.LENGTH_SHORT).show();
                        currentuser.child("email").setValue(email_text);
                        currentuser.child("name").setValue(name_text);
                        currentuser.child("firstname").setValue(firstname_text);
                        Intent Login = new Intent(signup.this, signup.class);
                        startActivity(Login);
                    }else{
                        Toast.makeText(signup.this, "Something is Wrong ! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent Login = new Intent(signup.this, Login.class);
        startActivity(Login);
    }
}
