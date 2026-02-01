package com.example.demo.todo;


import com.example.demo.todo.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/*
admin DB logic (database)
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    // No code needed! JpaRepository gives you save(), findAll(), deleteById(), etc.
}