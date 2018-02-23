package com.bullybot.bullybot.repository;

import com.bullybot.bullybot.models.Answer;
import com.bullybot.bullybot.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long>{

    List<Answer> findByTimestamp(String ts);
    List<Answer> findAllByIdThreadTs(String th);
    List<Answer> findById(long id);
    List<Answer> findByCorrectAnswer(boolean flag);
}
