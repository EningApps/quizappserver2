package com.quizapp.quiz.quizentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EntityController {

    @Autowired
    EntityRepository entityRepository;

    @GetMapping("/entities")
    public List<QuizEntity> getAllNotes() {
        return entityRepository.findAll();
    }

    @PostMapping("/entities")
    public QuizEntity createEntity(@Valid @RequestBody QuizEntity entity) {
        return entityRepository.save(entity);
    }
}
