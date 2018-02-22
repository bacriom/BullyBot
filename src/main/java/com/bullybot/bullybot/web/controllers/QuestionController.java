package com.bullybot.bullybot.web.controllers;

import com.bullybot.bullybot.models.Question;
import com.bullybot.bullybot.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/questions")
    public Iterable<Question> findAll(){
        return questionRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/questions/{id}")
    public List<Question> show(@PathVariable String id){
        return  questionRepository.findByIdChanel(id);
    }
}
