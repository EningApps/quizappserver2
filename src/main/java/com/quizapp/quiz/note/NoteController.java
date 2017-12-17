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

    private static final String[] ANSWERS={"teplovoz","bkg1","chme3","dr1p","drb1","epg","epr","er9t","ten60","vl80"};
    
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/answers")
    public String getAnswers(){
        String rez="";
        for(String s:ANSWERS)
            rez+=s+" ";
        rez=rez.substring(0,rez.length()-1);
        return rez;
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

}