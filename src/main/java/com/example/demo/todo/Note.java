package com.example.demo.todo;

import jakarta.persistence.*;
import lombok.Data;

/*
Models.py
 */

@Entity
@Data // This automatically generates Getters and Setters
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
}