package com.example.chooseyourownadventuretextbasedvideogame;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//once level 1 is complete, levels 2 through five are easy. Only hard part is the dialogue scenes between the characters


//replaced: import com.dragankrstic.autotypetextview.AutoTypeTextView;
import com.prush.typedtextview.TypedTextView;

public class Level1Activity extends AppCompatActivity{

    //TODO: Replace Buttons with clickable icons: Version 2.0 Patch: Update

    TextView adviceTxt, healthDescriberTxt, healthTxt, scoreDescriberTxt, scoreTxt, lvlDescriberTxt, statusTxt;
    TypedTextView scenarioTxt;
    Button decision1, decision2, startGameBtn;
    ProgressBar statusProgressBar;

    //should this be in the DecisionTime class?
    //or just use this for startgame code
    //
    String methodName = " ";
    final DecisionTime decisionTime = new DecisionTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        //initialize health and score, and other
        healthDescriberTxt = findViewById(R.id.healthDescribTxt);
        healthTxt = findViewById(R.id.healthTxt);
        scoreDescriberTxt = findViewById(R.id.scoreDescriberTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        scenarioTxt = findViewById(R.id.scenarioTxt);
        lvlDescriberTxt = findViewById(R.id.levelTxt);
        adviceTxt = findViewById(R.id.adviceTxt);
        statusTxt = findViewById(R.id.statusTxt);
        statusProgressBar = findViewById(R.id.statusProgressBar);
        startGameBtn = findViewById(R.id.startGameBtn);

        //decision buttons
        decision1 = findViewById(R.id.decision1Btn);
        decision2 = findViewById(R.id.decision2Btn);

        //invisibility
        statusProgressBar.setVisibility(View.VISIBLE);
        healthDescriberTxt.setVisibility(View.INVISIBLE);
        healthTxt.setVisibility(View.INVISIBLE);
        scoreDescriberTxt.setVisibility(View.INVISIBLE);
        scoreTxt.setVisibility(View.INVISIBLE);
        scenarioTxt.setVisibility(View.INVISIBLE);
        lvlDescriberTxt.setVisibility(View.INVISIBLE);
        adviceTxt.setVisibility(View.VISIBLE);
        statusTxt.setVisibility(View.VISIBLE);
        startGameBtn.setVisibility(View.INVISIBLE);

        decision1.setVisibility(View.INVISIBLE);
        decision2.setVisibility(View.INVISIBLE);

        //advice before game starts
        adviceTxt.animate().alpha(1.0f);
        statusTxt.animate().alpha(1.0f);
        statusProgressBar.animate().alpha(1.0f);
        CountDownTimer adviceSwitcherTimer = new CountDownTimer(21000, 2000) {
            int adviceCounter = 0;
            @Override
            public void onTick(long millisUntilFinished) {
                adviceCounter++;
                if (adviceCounter == 0){
                    adviceTxt.animate().alpha(1.0f).setDuration(1200);
                    adviceTxt.setText(R.string.level_1_advice_1);
                    statusTxt.setText(R.string.loading_1);
                }else if (adviceCounter == 3){
                    adviceTxt.setText(R.string.level_1_advice_2);
                    statusTxt.setText(R.string.loading_2);
                }else if (adviceCounter == 6) {
                    adviceTxt.setText(R.string.level_1_advice_3);
                    statusTxt.setText(R.string.loading_3);
                }else if (adviceCounter == 9) {
                    adviceTxt.setText(R.string.level_1_advice_4);
                    statusTxt.setText(R.string.loading_4);
                }
            }
            @Override
            public void onFinish() {
                adviceTxt.setText(R.string.level_1_advice_end);
                adviceTxt.setVisibility(View.INVISIBLE);
                statusTxt.setVisibility(View.INVISIBLE);
                //visibility onGame start
                healthDescriberTxt.setVisibility(View.VISIBLE);
                healthTxt.setVisibility(View.VISIBLE);
                scoreDescriberTxt.setVisibility(View.VISIBLE);
                scoreTxt.setVisibility(View.VISIBLE);
                lvlDescriberTxt.setVisibility(View.VISIBLE);
                statusProgressBar.setVisibility(View.INVISIBLE);
                adviceTxt.animate().alpha(0.0f).setDuration(1200);
                gameLobby();
            }
        };
        adviceSwitcherTimer.start();
    }

    public void gameLobby(){
        startGameBtn.animate().alpha(1.0f);
        startGameBtn.setVisibility(View.VISIBLE);
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGameBtn.setVisibility(View.INVISIBLE);
                onGameStart();
            }
        });
    }

    private void onGameStart() {

        View.OnClickListener shelter = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onShelterChosen();
                methodName = "shelter";
                onScenario();
            }
        };
        View.OnClickListener water = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onWaterChosen();
                methodName = "water";
                onScenario();
            }
        };
        decision1.setOnClickListener(shelter);
        decision2.setOnClickListener(water);
        //now is the actual game beginning

        scenarioTxt.setVisibility(View.VISIBLE);

        // switch back to Typing speed before if this leads to bug
        scenarioTxt.setTypedText(getString(R.string.starting_scenario));
        scenarioTxt.setTypingSpeed(100);

        //countdown timer is hacky solution, try to find code that runs when text stops typing: calculate charset, 100ms is per each character
        new CountDownTimer(45000, 1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {

                decision1.setVisibility(View.VISIBLE);
                decision2.setVisibility(View.VISIBLE);

                methodName = "start_scenario";
                onScenario();
            }
        }
        .start();
    }

    //for the calculating of the charset + timer?
    public void endOfScenarioText(){

    // blank string
          String scenarioName = decisionTime.getScenarioName();
          final String scenarioTextContents = decisionTime.getScenarioTextContent();

          scenarioTxt.setTypedText(scenarioTextContents);
          scenarioTxt.setTypingSpeed(100);

        //Set listener to invoke other actions based on status.
            scenarioTxt.setOnCharacterTypedListener( new TypedTextView.OnCharacterTypedListener() {
            @Override
            public void onCharacterTyped( char character, int index )
            {
                if(index == scenarioTextContents.length() - 1) {

                    decision1.setText(decisionTime.getDecisionBtn1());
                    decision2.setText(decisionTime.getDecisionBtn2());
                    decision1.setVisibility(View.VISIBLE);
                    decision2.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    // possibly merge this and decisionTime into one method, called: onScenario
    public void onScenario(){

        //maybe put default two view.onclick listeners which are edited each time

        decision1.setVisibility(View.INVISIBLE);
        decision2.setVisibility(View.INVISIBLE);

        switch (methodName) {
            //start
            case "start_scenario":

                View.OnClickListener shelter = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // onShelterChosen();
                        methodName = "shelter";
                        onScenario();
                    }
                };
                View.OnClickListener water = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // onWaterChosen();
                        methodName = "water";
                        onScenario();
                    }
                };
                decision1.setOnClickListener(shelter);
                decision2.setOnClickListener(water);

                decision1.setVisibility(View.VISIBLE);
                decision2.setVisibility(View.VISIBLE);

                decisionTime.setDecisionBtn1(R.string.find_shelter);
                decisionTime.setDecisionBtn2(R.string.find_water);
                decision1.setText(decisionTime.getDecisionBtn1());
                decision2.setText(decisionTime.getDecisionBtn2());

                break;

            //tier two scenarios
            case "shelter":

                //v.onclick
                View.OnClickListener stay_and_rest = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "stay_and_rest";
                        onScenario();
                    }
                };
                View.OnClickListener leave_the_cave = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "leave_cave";
                        onScenario();
                    }
                };

                decision1.setOnClickListener(stay_and_rest);
                decision2.setOnClickListener(leave_the_cave);

                //scenario
                // switch back to Typing speed before if this leads to bug
                decisionTime.setScenarioTextContent(String.valueOf(R.string.shelter_scenario));
                endOfScenarioText();

                //decision, merge into endOfScenarioText with changeable/mutable variables
                decisionTime.setDecisionBtn1(R.string.stay_and_rest);
                decisionTime.setDecisionBtn2(R.string.leave_the_cave);

                break;

            case "water":
                //v.onclick
                View.OnClickListener get_some_water = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "get_water";
                        onScenario();
                    }
                };
                View.OnClickListener catch_some_fish = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "catch_fish";
                        onScenario();
                    }
                };

                decision1.setOnClickListener(get_some_water);
                decision2.setOnClickListener(catch_some_fish);

                //scenario

                decisionTime.setScenarioTextContent(String.valueOf(R.string.water_scenario));
                endOfScenarioText();
                //decision

                decisionTime.setDecisionBtn1(R.string.get_some_water);
                decisionTime.setDecisionBtn2(R.string.try_to_catch_fish);
                break;

            //tier three scenarios
                //shelter
            case "stay_and_rest":

                //v.onclick
                View.OnClickListener run_from_cave = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "run_from_cave";
                        onScenario();
                    }
                };
                View.OnClickListener play_dead = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "play_dead";
                        onScenario();
                    }
                };
                decision1.setOnClickListener(run_from_cave);
                decision2.setOnClickListener(play_dead);

                //scenario
                decisionTime.setScenarioTextContent(String.valueOf(R.string.stay_in_cave));
                endOfScenarioText();

                //decision
                decisionTime.setDecisionBtn1(R.string.run_from_cave);
                decisionTime.setDecisionBtn2(R.string.play_dead);
                break;

            case "leave_cave":

                View.OnClickListener try_to_get_to_hut = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "try_to_get_to_hut";
                        onScenario();
                    }
                };
                View.OnClickListener sleep = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        methodName = "sleep";
                        onScenario();
                    }
                };
                decision1.setOnClickListener(try_to_get_to_hut);
                decision2.setOnClickListener(sleep);

                //scenario

                decisionTime.setScenarioTextContent(String.valueOf(R.string.leave_cave));
                endOfScenarioText();

                //decision
                decisionTime.setDecisionBtn1(R.string.try_get_to_hut);
                decisionTime.setDecisionBtn2(R.string.sleep);

                break;

                //water
            case "get_water":

                break;

            case "catch_fish":
                //something
                break;


        }


    }
}