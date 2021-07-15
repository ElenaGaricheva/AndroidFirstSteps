package com.example.androidfirststeps;

public class Calculator {
    private int num1 = 0;
    private String num2 = "";
    private String currentOperand;
    private int currentCalc = 0;

    public void setCurrentCalc(int currentCalc) {
        this.currentCalc += currentCalc;
    }

    public int getCurrentCalc() {
        return currentCalc;
    }

    public void setCurrentOperand(String currentOperand) {
        this.currentOperand = currentOperand;
    }

    public void setNum1(int num1) {
        this.num1 += num1;
    }

    public void setNum2(String num2) {
        this.num2 += num2;
    }

    public String getCurrentOperand() {
        return currentOperand;
    }

    public void calculation() {
        switch (currentOperand) {
            case "+":
                currentCalc = num1 + Integer.parseInt(num2);
                break;
            case "-":
                currentCalc = num1 - Integer.parseInt(num2);
                break;
            case "x":
                currentCalc = num1 * Integer.parseInt(num2);
                break;
            case "/":
                currentCalc = num1 / Integer.parseInt(num2);
                break;
        }
    }

    public void resetParam() {
        num2 = "";
        num1 = 0;
        currentCalc = 0;
        currentOperand = null;
    }
}
