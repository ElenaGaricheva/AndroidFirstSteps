package com.example.androidfirststeps;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;


public class Calculator implements Parcelable {
    private int num1 = 0;
    private String num2 = "";
    private String currentOperand = null;
    private int currentCalc;
    private String currentText = "";
    private static int themeColor = R.style.Theme_AndroidFirstSteps;

    public Calculator() {
    }

    protected Calculator(Parcel in) {
        num1 = in.readInt();
        num2 = in.readString();
        currentOperand = in.readString();
        currentCalc = in.readInt();
        currentText = in.readString();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

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

    public void setCurrentText(String currentText) {
        this.currentText = currentText;
    }

    public String getCurrentText() {
        return currentText;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(num1);
        dest.writeString(num2);
        dest.writeString(currentOperand);
        dest.writeInt(currentCalc);
        dest.writeString(currentText);
    }

    public static int getThemeColor() {
        return themeColor;
    }

    public static void setThemeColor(int themeColor) {
        Calculator.themeColor = themeColor;
    }
}
