package com.quizapp.quiz.note;


import com.quizapp.quiz.note.NoteRepository;
import com.quizapp.quiz.note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

}