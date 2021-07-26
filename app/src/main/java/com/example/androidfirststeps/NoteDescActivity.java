package com.example.androidfirststeps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_desc);

        NoteDescriptionFragment noteDetails = new NoteDescriptionFragment();
        noteDetails.setArguments(getIntent().getExtras());
        // Добавим фрагмент на activity
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.noteDesc, noteDetails).commit();
    }
}
