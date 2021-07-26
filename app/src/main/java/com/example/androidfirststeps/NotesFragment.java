package com.example.androidfirststeps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesFragment extends Fragment {

    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    //Вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout notesView = (LinearLayout) view;
        Note[] notes = new Note[5];

        for (Note note : notes) {
            LinearLayout noteView = (LinearLayout) view;
            noteView.setOrientation(LinearLayout.VERTICAL);
            TextView noteNameView = new TextView(getContext());
            TextView noteDescriptionView = new TextView(getContext());
            TextView creationDateView = new TextView(getContext());
            noteNameView.setText(note.getNoteName());
            noteDescriptionView.setText(note.getNoteDescription());
            creationDateView.setText(note.getCreationDate());
            noteView.addView(noteNameView);
            noteView.addView(noteDescriptionView);
            noteView.addView(creationDateView);
            notesView.addView(noteView);
        }
    }
}