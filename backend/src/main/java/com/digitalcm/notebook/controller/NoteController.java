package com.digitalcm.notebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digitalcm.notebook.model.Note;
import com.digitalcm.notebook.service.NoteService;
import java.util.List;

// GET /api/notes - get all notes
// POST /api/notes - create new note

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note.getTitle(), note.getDescription());
    }
}
