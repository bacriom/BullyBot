package com.bullybot.bullybot.web.controllers;

import com.bullybot.bullybot.message.Response;
import com.bullybot.bullybot.models.Chanel;
import com.bullybot.bullybot.models.Question;
import com.bullybot.bullybot.repository.ChanelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    ChanelRepository chanelRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/channels")
    public Iterable<Chanel> findAll(){
        //List<Chanel> channels = chanelRepository.findAll();

        //return new Response("Done",channels);
        return chanelRepository.findAll();
    }
}
