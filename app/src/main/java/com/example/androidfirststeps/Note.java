package com.example.androidfirststeps;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private String noteDescription;

    protected Note(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        creationDate = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    private String creationDate;

    public Note(String noteName, String noteDescription, String creationDate) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.creationDate = creationDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(noteDescription);
        dest.writeString(creationDate);
    }
}
