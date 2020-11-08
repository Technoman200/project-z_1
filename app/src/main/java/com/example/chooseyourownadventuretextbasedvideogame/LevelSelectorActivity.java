package com.example.chooseyourownadventuretextbasedvideogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelectorActivity extends AppCompatActivity {

    Button lvl1Btn, lvl2Btn, lvl3Btn, lvl4Btn, lvl5Btn;

    //creates new onclicklisteners with intents

    private View.OnClickListener lvl1Selected = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lvl1Transition = new Intent(getApplicationContext(), Level1Activity.class);
            startActivity(lvl1Transition);
        }
    };
    private View.OnClickListener lvl2Selected = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lvl2Transition = new Intent(getApplicationContext(), Level2Activity.class);
            startActivity(lvl2Transition);
        }
    };
    private View.OnClickListener lvl3Selected = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lvl3Transition = new Intent(getApplicationContext(), Level3Activity.class);
            startActivity(lvl3Transition);
        }
    };
    private View.OnClickListener lvl4Selected = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lvl4Transition = new Intent(getApplicationContext(), Level4Activity.class);
            startActivity(lvl4Transition);
        }
    };
    private View.OnClickListener lvl5Selected = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lvl5Transition = new Intent(getApplicationContext(), Level5Activity.class);
            startActivity(lvl5Transition);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselector);

        //initializes declared level buttons
        lvl1Btn = findViewById(R.id.lvl1Btn);
        lvl2Btn = findViewById(R.id.lvl2Btn);
        lvl3Btn = findViewById(R.id.lvl3Btn);
        lvl4Btn = findViewById(R.id.lvl4Btn);
        lvl5Btn = findViewById(R.id.lvl5Btn);

        //sets onclick listeners
        lvl1Btn.setOnClickListener(lvl1Selected);
        lvl2Btn.setOnClickListener(lvl2Selected);
        lvl3Btn.setOnClickListener(lvl3Selected);
        lvl4Btn.setOnClickListener(lvl4Selected);
        lvl5Btn.setOnClickListener(lvl5Selected);


        //makes the buttons except for level 1 invisible and unclickable
/*
        lvl2Btn.setVisibility(View.INVISIBLE);
        lvl2Btn.setEnabled(false);

        lvl2Btn.setVisibility(View.INVISIBLE);
        lvl2Btn.setEnabled(false);

        lvl2Btn.setVisibility(View.INVISIBLE);
        lvl2Btn.setEnabled(false);

        lvl2Btn.setVisibility(View.INVISIBLE);
        lvl2Btn.setEnabled(false);

        lvl2Btn.setVisibility(View.INVISIBLE);
        lvl2Btn.setEnabled(false);
*/






    }
}