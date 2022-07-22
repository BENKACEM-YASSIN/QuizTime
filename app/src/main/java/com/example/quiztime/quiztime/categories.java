package com.example.quiztime.quiztime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class categories extends Fragment {

    View myview = null;
        public categories() {
        // Required empty public constructor
    }

    ImageView football,countries,celebreties,brands,cars,scientists,cities,music,basketball;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.fragment_categories,container,false);
        // Inflate the layout for this fragment

        football =(ImageView) myview.findViewById(R.id.football);
        countries =(ImageView) myview.findViewById(R.id.countries);
        celebreties =(ImageView) myview.findViewById(R.id.celebreties);
        brands =(ImageView) myview.findViewById(R.id.brands);
        cars =(ImageView) myview.findViewById(R.id.cars);
        scientists =(ImageView) myview.findViewById(R.id.scientists);
        cities =(ImageView) myview.findViewById(R.id.cities);
        music =(ImageView) myview.findViewById(R.id.music);
        basketball =(ImageView) myview.findViewById(R.id.basketball);

        //imad@gmail.com
        //imad0102

        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent footballquestions = new Intent(getContext(),QuestActivity.class);
                footballquestions.putExtra("catimage",R.drawable.footballcat);
                startActivity(footballquestions);
            }
        });

        countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent countriesquestions = new Intent(getContext(),CountriesQuestions.class);
                countriesquestions.putExtra("catimage",R.drawable.countcat);
                startActivity(countriesquestions);
            }
        });
        celebreties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent celebritiesquestions = new Intent(getContext(),CelebrityQuestions.class);
                celebritiesquestions.putExtra("catimage",R.drawable.starcat);
                startActivity(celebritiesquestions);
            }
        });

        brands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brandsquestions = new Intent(getContext(),BrandsQuestions.class);
                brandsquestions.putExtra("catimage",R.drawable.brandscat);
                startActivity(brandsquestions);
            }
        });
        return myview;
    }



}
