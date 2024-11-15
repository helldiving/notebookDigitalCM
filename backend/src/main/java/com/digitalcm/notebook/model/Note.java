package com.digitalcm.notebook.model;

// Create a server that stores a object that contains a note with a title and a description
// id for note
// title for note
// description for note

public class Note {

    private Integer id;
    private String title;
    private String description;

    public Note(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
