package com.example.test.demo.controller;

import com.example.test.Action.LoginAction;
import com.example.test.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(@ModelAttribute User user, Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public ModelAndView profile(@ModelAttribute User user, ModelAndView mav)
    {
        user.getUserName();
        LoginAction login = new LoginAction();
        String page = login.execute(user.getUserName(), user.getUserPassword());
        User foundUser = login.getUser(user.getUserName(), user.getUserPassword());
        
        if(foundUser.getUserName() == null || foundUser.getUserPassword() == null){
            mav.setViewName(page);
        }else{
            mav.setViewName(page);
            mav.addObject("user", user);
        }
        
        return mav;
    }

    @RequestMapping(value="/signup")
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView();

        return mav;
    }
}
