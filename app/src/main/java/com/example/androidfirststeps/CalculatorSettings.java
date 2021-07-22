package com.example.androidfirststeps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class CalculatorSettings extends AppCompatActivity {

    private Button darkTheme;
    private Button lightTheme;
    private Button backToCalc;
    private MaterialButtonToggleGroup themeSwitcher;
    private int calcTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_settings);

        calcTheme = Calculator.getThemeColor();

        initView();
    }

    @SuppressLint("ResourceType")
    private void initView() {
        darkTheme = findViewById(R.id.dark_theme);
        lightTheme = findViewById(R.id.light_theme);
        backToCalc = findViewById(R.id.back_to_cacl);
        themeSwitcher = findViewById(R.id.themeSwitcher);
        themeSwitcher.setSingleSelection(true);

        if (calcTheme == R.style.Theme_AndroidFirstSteps) {
            themeSwitcher.check(R.id.light_theme);
        } else if (calcTheme == R.style.Theme_AndroidFirstSteps_Dark) {
            themeSwitcher.check(R.id.dark_theme);
        }

        themeSwitcher.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (group.getCheckedButtonId() == darkTheme.getId()) {
                Calculator.setThemeColor(R.style.Theme_AndroidFirstSteps_Dark);
            } else if (group.getCheckedButtonId() == lightTheme.getId()) {
                Calculator.setThemeColor(R.style.Theme_AndroidFirstSteps);
            }
        });

        backToCalc.setOnClickListener(v -> {
            finish();
        });
    }
}
