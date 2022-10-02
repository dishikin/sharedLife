package com.example.test.demo.Action;

import com.example.test.demo.Entity.User;

import com.example.test.demo.Logic.SystemException;

import org.springframework.web.servlet.ModelAndView;

import com.example.test.demo.Logic.SignUpLogic;

public class SignUpAction {
    public SignUpAction(){

    }

    public String execute(ModelAndView mav, User user){
        String page = "profile";
        User newUser = null;

        if(user == null){
            page = "errorPage";
            return page;
        }
        try{
            SignUpLogic sLogic = new SignUpLogic();
            newUser = sLogic.signUp(user);
            if(newUser != null){
                page = "profile";
                mav.addObject("newUser", newUser);
            }
        }catch(SystemException e){
            e.printStackTrace();
            page = "systemErrorPage";
        }
        return page;
    }
}
