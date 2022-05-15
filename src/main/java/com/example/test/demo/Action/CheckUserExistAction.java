package com.example.test.demo.Action;

import com.example.test.demo.Logic.BusinessException;
import com.example.test.demo.Logic.SystemException;

import com.example.test.demo.Logic.CheckUserExistLogic;

import org.springframework.web.servlet.ModelAndView;


public class CheckUserExistAction {
    
    public Boolean checkUserExist(ModelAndView mav, String username){
        Boolean userExist = true;
        
        try{
            CheckUserExistLogic eLogic = new CheckUserExistLogic();
            userExist = eLogic.checkUserExist(username);
        }catch(BusinessException e){
            e.printStackTrace();
            String message = e.getMessage();
            mav.addObject("message", message);
        }catch(SystemException e){
            e.printStackTrace();
            
        }
        return userExist;
    }

}
