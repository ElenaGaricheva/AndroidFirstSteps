package com.example.androidfirststeps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorSettings extends AppCompatActivity implements View.OnClickListener{


    private Button darkTheme;
    private Button lightTheme;
    private Button backToCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_settings);

        initView();
    }

    private void initView() {
        darkTheme = findViewById(R.id.dark_theme);
        lightTheme = findViewById(R.id.light_theme);
        backToCalc = findViewById(R.id.back_to_cacl);

        darkTheme.setOnClickListener(this);
        lightTheme.setOnClickListener(this);

        MainActivity.calcTheme = R.style.Theme_AndroidFirstSteps_Dark;

        backToCalc.setOnClickListener(v -> {
            Intent backToCalc = new Intent(CalculatorSettings.this, MainActivity.class);
            startActivity(backToCalc);
            finish();
        });
    }


    @Override
    public void onClick(View v) {
    }
}
