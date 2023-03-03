package com.example.irite;

import static com.example.irite.SplashActivity.list;
import static com.example.irite.SplashActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressbar;
    List<modelclass> allQuestionList;
    modelclass Modelclass;
    int index = 0;
    TextView card_question, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();
//        allQuestionList =list;
//        Collections.shuffle(allQuestionList);
//        Modelclass =list.get(index);


        setAllData();
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

        nextBtn.setClickable(false);


        countDownTimer = new CountDownTimer(20000, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue - 1;
                progressbar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {

                Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialogue);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dailog);

                dialog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();

    }
    private void Hooks() {
        progressbar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optiona);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.nextBtn);

    }
    private void setAllData() {
        card_question.setText(Modelclass.getQuestion());
        optiona.setText(Modelclass.getoA());
        optionb.setText(Modelclass.getoB());
        optionc.setText(Modelclass.getoC());
        optiond.setText(Modelclass.getoD());
    }

    public void Correct(CardView cardView) {
        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                Modelclass = list.get(index);
                setAllData();
            }
        });

    }

    public void wrong(CardView cardView) {

        cardView.setCardBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index < list.size() - 1) {
                    index++;
                    Modelclass = list.get(index);
                    setAllData();
                    resetColor();
                } else {
                    Gamewon();
                }
            }
        });

    }

    private void Gamewon() {
        Intent intent = new Intent(DashboardActivity.this, wonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

    public void enableButton() {
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton() {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);

    }

    public void resetColor() {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

    }

    public void optionaClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (Modelclass.getoA().equals((Modelclass.getAns()))) {
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardOA);
            } else {
                Gamewon();
            }
        } else {
            wrong(cardOA);
        }
    }

    public void optionbClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (Modelclass.getoB().equals((Modelclass.getAns()))) {
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardOB);
            } else {
                Gamewon();
            }
        } else {
            wrong(cardOB);
        }
    }

    public void optioncClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (Modelclass.getoC().equals((Modelclass.getAns()))) {
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardOC);
            } else {
                Gamewon();
            }
        } else {
            wrong(cardOC);
        }
    }

    public void optiondClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (Modelclass.getoD().equals((Modelclass.getAns()))) {
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardOD);
            } else {
                Gamewon();
            }
        } else {
            wrong(cardOD);
        }
    }

}