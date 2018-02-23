package com.bullybot.bullybot.repository;

import com.bullybot.bullybot.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String>{
    List<Question> findByTimeStamp (String ts);
    List<Question> findByIdChanel(String channel);
}
