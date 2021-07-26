package com.example.androidfirststeps;

public class Note {
    private String noteName;
    private String noteDescription;

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


}
