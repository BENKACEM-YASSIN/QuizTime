package com.example.quiztime.quiztime;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class GameActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mDrawerlayout   = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.Open,R.string.Close);
        NavigationView nvDrawer = (NavigationView)findViewById(R.id.menubar);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layoutaccueil,new categories()).commit();

    }
    //imad@gmail.com
    //imad0102

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void selectitemMenu(MenuItem menuItem){
        Fragment myfragment  = null;
        Class fragmentclass;
        switch(menuItem.getItemId()){
            case R.id.categoiries:
                fragmentclass = categories.class;
                categories fragcat = new categories();
                FragmentManager fragmentManagercat = getSupportFragmentManager();
                fragmentManagercat.beginTransaction().replace(R.id.layoutaccueil,fragcat).commit();
                break;
            case R.id.friendshighscore :
                fragmentclass =  FriendsHighScoreCat.class;
                FriendsHighScoreCat friendshighscore = new FriendsHighScoreCat();
                FragmentManager fragmentManagerhigfriendshighscore = getSupportFragmentManager();
                fragmentManagerhigfriendshighscore.beginTransaction().replace(R.id.layoutaccueil,friendshighscore).commit();
                break;
            case R.id.logout :
                fragmentclass = Login.class;
                Intent login = new Intent(GameActivity.this,Login.class);
                startActivity(login);
                break;
            case R.id.Categorieshighcore :
               fragmentclass = EachCategorieHighScore.class;
                Intent cathighscore = new Intent(GameActivity.this,EachCategorieHighScore.class);
                startActivity(cathighscore);
                break;
            default :
                fragmentclass = categories.class;

        }
        try {
            myfragment=(Fragment)fragmentclass.newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerlayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectitemMenu(item);
                return false;
            }
        });
    }
}
