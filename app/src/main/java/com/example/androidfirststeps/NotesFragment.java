package com.example.androidfirststeps;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
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
        Note[] notes = {
                new Note("name1", "desc1", "date1"),
                new Note("name2", "desc2", "date2")
        };

        for (Note note : notes) {
            LinearLayout noteView = createNoteView(note);
            noteView.setOnClickListener(v -> {
                Intent noteDescription = new Intent();
                noteDescription.setClass(getContext(), NoteDescActivity.class);
                noteDescription.putExtra("NOTE_RECORD", note);

                startActivity(noteDescription);
            });
            noteView.setOrientation(LinearLayout.VERTICAL);
            noteView.setPadding(0, 0, 0, 16);

            notesView.addView(noteView);
        }
    }

    private LinearLayout createNoteView(Note record) {
        LinearLayout note = new LinearLayout(getContext());
        note.setOrientation(LinearLayout.VERTICAL);
        note.setPadding(0, 0, 0, 16);

        TextView noteNameView = new TextView(getContext());
        noteNameView.setTextSize(24);
        TextView noteDescriptionView = new TextView(getContext());
        noteDescriptionView.setTextSize(16);
        TextView creationDateView = new TextView(getContext());
        creationDateView.setTextSize(8);

        noteNameView.setText(record.getNoteName());
        noteDescriptionView.setText(record.getNoteDescription());
        creationDateView.setText(record.getCreationDate());

        note.addView(noteNameView);
        note.addView(noteDescriptionView);
        note.addView(creationDateView);

        return note;
    }
}