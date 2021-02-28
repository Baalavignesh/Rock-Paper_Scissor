package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rock;
    private Button paper;
    private Button scissor;


    private TextView system;
    final int min = 0;
    final int max = 2;
    int user_choice = 0;
    int system_choice = 0;

    String system_1;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = (Button) findViewById(R.id.rock);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rock();
            }
        });

        paper = (Button) findViewById(R.id.paper);
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paper();
            }
        });

        scissor = (Button) findViewById(R.id.scissor);
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scissor();
            }
        });

    }

    public void get_number() {
        system_choice = new Random().nextInt((max - min) + 1) + min;
        Log.d("myTag", "system_choice: " + system_choice);

        switch (system_choice) {
            case 0:
                system_1 = "Rock";
                break;
            case 1:
                system_1 = "Paper";
                break;
            case 2:
                system_1 = "Scissor";
                break;
            default:
                system_1 = "Error";
        }
    }


    public void result_function(int a) {
        Log.d("myTag", "value: " + a);
        switch (a) {
            case 0:
                if(system_choice == 0) {
                    result = "Draw";
                }
                if(system_choice == 1) {
                    result = "Lose";
                }
                if(system_choice == 2) {
                    result = "Win";
                }
                break;
            case 1:
                if(system_choice == 0) {
                    result = "Win";
                }
                if(system_choice == 1) {
                    result = "Draw";
                }
                if(system_choice == 2) {
                    result = "Lose";
                }
                break;
            case 2:
                if(system_choice == 0) {
                    result = "Lose";
                }
                if(system_choice == 1) {
                    result = "Win";
                }
                if(system_choice == 2) {
                    result = "Draw";
                }
                break;

            default:
                result = "Error";

        }
    }

    public void rock() {

        get_number();
        system = (TextView) findViewById(R.id.sys_choice);
        Log.d("myTag", "system in word: " + system_1);
        system.setText(system_1);

        user_choice = 0;
        Log.d("myTag", "user Choice: " + user_choice);
        result_function(user_choice);
//        Log.d("myTag", "value: " + result);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), ResultPage.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        }, 2000);


    }

    public void paper() {

        get_number();
        system = (TextView) findViewById(R.id.sys_choice);
        Log.d("myTag", "system in word: " + system_1);
        system.setText(system_1);

        user_choice = 1;
        Log.d("myTag", "user Choice: " + user_choice);
        result_function(user_choice);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), ResultPage.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        }, 2000);
    }

    public void scissor() {
        get_number();
        system = (TextView) findViewById(R.id.sys_choice);
        Log.d("myTag", "system in word: " + system_1);
        system.setText(system_1);

        user_choice = 2;
        Log.d("myTag", "user Choice: " + user_choice);
        result_function(user_choice);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), ResultPage.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        }, 2000);
    }
}