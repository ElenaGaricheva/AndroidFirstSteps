package com.example.androidfirststeps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Flow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView inputField;
    private TextView outputField;
    private Flow buttonsContainer;
    private Button settingsButton;
    private final static String keyCalculator = "Calculator";

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Calculator.getThemeColor());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initView();
    }

    private void initView() {

        inputField = findViewById(R.id.inputField);
        outputField = findViewById(R.id.outputField);
        buttonsContainer = findViewById(R.id.buttonsFlow);
        settingsButton = findViewById(R.id.settings_button);

        calculator = new Calculator();

        initButtonsClickListener();

        settingsButton.setOnClickListener(v -> {
            Intent goToSettings = new Intent(MainActivity.this, CalculatorSettings.class);
            goToSettings.putExtra("CALC_THEME", Calculator.getThemeColor());
            startActivity(goToSettings);
        });
    }

    private void initButtonsClickListener() {
        int[] buttonsId = buttonsContainer.getReferencedIds();
        for (int id : buttonsId) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View v) {

        Button button = (Button) v;
        calculator.setCurrentText(inputField.getText().toString());

        if (button.getId() == R.id.deleting) {
            inputField.setText(null);
            outputField.setText(null);
            calculator.resetParam();
        } else if (button.getId() == R.id.equalSign) {
            inputField.setText(Integer.toString(calculator.getCurrentCalc()));
            outputField.setText(null);
            calculator.resetParam();
        } else if (button.getId() == R.id.plus ||
                button.getId() == R.id.minus ||
                button.getId() == R.id.multiply ||
                button.getId() == R.id.split) {
            calculator.setCurrentOperand(button.getText().toString());
            calculator.setNum1(Integer.parseInt(calculator.getCurrentText()));
            inputField.setText(calculator.getCurrentText() + button.getText().toString());
        } else {
            {
                calculator.setCurrentText(calculator.getCurrentText() + button.getText().toString());
                inputField.setText(calculator.getCurrentText());

                if (calculator.getCurrentOperand() == null) {
                    calculator.setCurrentCalc(Integer.parseInt(calculator.getCurrentText()));
                    outputField.setText(calculator.getCurrentText());
                } else {
                    calculator.setNum2(button.getText().toString());
                    calculator.calculation();
                    outputField.setText(Integer.toString(calculator.getCurrentCalc()));
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCalculator, calculator);
        int currentOrientation = this.getResources().getConfiguration().orientation;

        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculator = instanceState.getParcelable(keyCalculator);
        setTextField();
    }

    private void setTextField() {
        inputField.setText(calculator.getCurrentText());
        outputField.setText(calculator.getCurrentCalc());
    }
}
