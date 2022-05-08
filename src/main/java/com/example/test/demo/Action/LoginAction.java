package com.example.test.demo.Action;

import com.example.test.demo.Entity.User;
import com.example.test.demo.Logic.BusinessException;
import com.example.test.demo.Logic.SystemException;

import org.springframework.web.servlet.ModelAndView;

import com.example.test.demo.Logic.FindUserLogic;
import com.example.test.demo.Logic.CheckPassLogic;


public class LoginAction {
    /**
     * @param username
     * @param password
     * @return nextWebpage
     */

     public String execute(ModelAndView mav, String username, String password){
        String page = "login";

        if(username == null || password == null){
            page = "errorPage";
            return page;
        }

        try{
            //Pass the information to logic to deal with finding the user.
            FindUserLogic logic = new FindUserLogic();
            User user = logic.findUser(username, password);
            if(user != null){
                page = "profile";
                mav.addObject("user", user);
            }
        }catch(BusinessException e){
            e.printStackTrace();
            String message = e.getMessage();
            mav.addObject("message", message);
        }catch(SystemException e){
            e.printStackTrace();
            page = "systemErrorPage";
        }

        return page;
     }

     public Boolean checkUser(String username, String password, ModelAndView mav){
        Boolean check = null;
        try{
            CheckPassLogic cpl = new CheckPassLogic();
            check = cpl.checkPass(username, password);
        }catch(BusinessException e){
            e.printStackTrace();
            String message = e.getMessage();
            mav.addObject("message", message);
        }catch(SystemException e){
            e.printStackTrace();
        }

        return check;
     }
}
