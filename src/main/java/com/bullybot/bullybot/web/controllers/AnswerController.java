package com.bullybot.bullybot.web.controllers;

import com.bullybot.bullybot.models.Answer;
import com.bullybot.bullybot.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/answers")
    public Iterable<Answer> findAll(){
        return answerRepository.findAll();
    }
}
