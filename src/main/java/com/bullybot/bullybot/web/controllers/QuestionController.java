package com.bullybot.bullybot.web.controllers;

import com.bullybot.bullybot.models.Question;
import com.bullybot.bullybot.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/questions")
    public Iterable<Question> findAll(){
        return questionRepository.findAll();
    }
}
