import React, { useEffect, useState } from "react";

// Create a front end that shows all objects on the server.
// Create a way to add objects to the server through the frontend.

// needs to manage showing and creating notes //
// useState used for: store the notes array, track loading state, and for input
// useEffect used for: trigger the fetch when component loads
// Async used for:

function NoteList() {
  // stores notes array
  const [notes, setNotes] = useState([]);

  // stores input
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  useEffect(() => {
    getNotes();
  }, []);

  const getNotes = async () => {
    const response = await fetch("http://localhost:8080/api/notes");
    const data = await response.json();
    setNotes(data);
  };

  // submit input /set
  const handleSubmit = async (e) => {
    e.preventDefault();
    await fetch("http://localhost:8080/api/notes", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: title,
        description: description,
      }),
    });

    setTitle("");
    setDescription("");
    getNotes();
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="Title"
        />
        <input
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="Description"
        />
        <button type="submit">Add Note</button>
      </form>

      {notes.map((note) => (
        <div key={note.id}>
          <h3>{note.title}</h3>
          <p>{note.description}</p>
        </div>
      ))}
    </div>
  );
}

export default NoteList;
