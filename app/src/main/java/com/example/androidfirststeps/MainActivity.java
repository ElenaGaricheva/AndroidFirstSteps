package com.example.androidfirststeps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initView();
    }

    private TextView inputField;
    private TextView outputField;
    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;
    private LinearLayout container5;
    Calculator calculator;

    private void initView() {

        inputField = findViewById(R.id.inputField);
        outputField = findViewById(R.id.outputField);
        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);
        container4 = findViewById(R.id.container4);
        container5 = findViewById(R.id.container5);

        calculator = new Calculator();

        initButtonsClickListener();
    }

    private void initButtonsClickListener() {
        LinearLayout[] containers = new LinearLayout[]{
                container1, container2, container3, container4, container5};

        for (LinearLayout container : containers) {
            for (int i = 0; i < container.getChildCount(); i++) {
                Button button = (Button) container.getChildAt(i);
                button.setOnClickListener(this);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View v) {

        Button button = (Button) v;
        String currentText = inputField.getText().toString();

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
            calculator.setNum1(Integer.parseInt(currentText));
            inputField.setText(currentText + button.getText().toString());
        } else {
            {
                currentText += button.getText().toString();
                inputField.setText(currentText);

                if (calculator.getCurrentOperand() == null) {
                    outputField.setText(currentText);
                    calculator.setCurrentCalc(Integer.parseInt(currentText));
                } else {
                    calculator.setNum2(button.getText().toString());
                    calculator.calculation();
                    outputField.setText(Integer.toString(calculator.getCurrentCalc()));
                }
            }
        }
    }
}