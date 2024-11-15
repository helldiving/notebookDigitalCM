package com.digitalcm.notebook.service;
import java.util.ArrayList;
import java.util.List;

import com.digitalcm.notebook.model.Note;

public class NoteService {

    private List<Note> noteList = new ArrayList<>();
    private int idTracking = 0;

    public List<Note> getAllNotes() {
        return noteList;
    }

    public Note addNote(String title, String description) {
        Note note = new Note(++idTracking, title, description);
        noteList.add(note);
        return note;
    }
    
}
