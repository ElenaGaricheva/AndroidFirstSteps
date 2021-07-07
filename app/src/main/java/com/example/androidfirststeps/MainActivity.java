package com.example.androidfirststeps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);
    }

    public void onToggleClicked(View view) {
    }

    public void onCheckboxClicked(View view) {
    }

    public void sendMessage(View view) {
    }
}