package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    private Button previous_page;
    private TextView result_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        Intent myIntent = getIntent(); // gets the previously created intent
        String final_result = myIntent.getStringExtra("result");

        Log.d("myTag", "value: " + final_result);
        result_1 = (TextView) findViewById(R.id.result);
        result_1.setText(final_result);

        previous_page = (Button) findViewById(R.id.previous_page);
        previous_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    public void goBack()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}