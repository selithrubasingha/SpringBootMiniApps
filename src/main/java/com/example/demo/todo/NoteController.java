package com.example.demo.todo;

import com.example.demo.todo.Note;
import com.example.demo.todo.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

Views.py + urls.py
 */

@RestController
@RequestMapping("/api/notes") // This is the base URL (like urls.py)
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping // GET /api/notes
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @PostMapping // POST /api/notes
    public Note createNote(@RequestBody Note note) {
        return repository.save(note);
    }

    @DeleteMapping("/{id}") // DELETE /api/notes/1
    public void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }
}