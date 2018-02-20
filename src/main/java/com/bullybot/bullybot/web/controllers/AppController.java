package com.bullybot.bullybot.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

//
//    @RequestMapping("/")
//    public ModelAndView home(ModelAndView modelAndView){
//        modelAndView.setViewName("home");
//        return modelAndView;
//    }

    @RequestMapping("/")
    public String home(){
        return "indelx";
    }
}
