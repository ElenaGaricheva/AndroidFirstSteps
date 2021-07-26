package com.example.androidfirststeps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteDescriptionFragment extends Fragment{

    private Note noteRecord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        noteRecord = getArguments().getParcelable("NOTE_RECORD");

        return inflater.inflate(R.layout.fragment_note_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view, noteRecord);
    }

    private void initView(View view, Note noteRecord) {
        TextView noteName = view.findViewById(R.id.noteName);
        TextView noteDesc = view.findViewById(R.id.noteDescription);
        TextView creationDate = view.findViewById(R.id.creationDate);

        noteName.setText(noteRecord.getNoteName());
        noteDesc.setText(noteRecord.getNoteDescription());
        creationDate.setText(noteRecord.getCreationDate());

    }
}