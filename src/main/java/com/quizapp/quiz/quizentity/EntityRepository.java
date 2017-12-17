package com.quizapp.quiz.quizentity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.12.2017.
 */
@Repository
public interface EntityRepository extends JpaRepository<QuizEntity, Long> {

}
