package com.example.test.demo.controller;

import com.example.test.demo.Action.LoginAction;
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
        Boolean check = login.checkUser(user.getUserName(), user.getUserPassword(), mav);
        if(check == null){
            mav.setViewName("login");
            return mav;
        }else{
            String page = login.execute(mav, user.getUserName(), user.getUserPassword());
            mav.setViewName(page);
        }
        
        return mav;
    }

    @RequestMapping(value="/signup")
    public ModelAndView signup(@ModelAttribute User user, ModelAndView mav){
        mav.addObject("user", new User());
        mav.setViewName("signup");
        return mav;
    }
}
