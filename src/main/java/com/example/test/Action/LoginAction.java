package com.example.test.Action;

import com.example.test.demo.Entity.User;
import com.example.test.demo.Logic.BusinessException;
import com.example.test.demo.Logic.SystemException;
import com.example.test.demo.Logic.FindUserLogic;


public class LoginAction {
    /**
     * @param mav
     * @param username
     * @param password
     * @return nextWebpage
     */

     public String execute(String username, String password){
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
            }
            
        }catch(BusinessException e){
            e.printStackTrace();
            page = "errorPage";
        }catch(SystemException e){
            e.printStackTrace();
            page = "systemErrorPage";
        }

        return page;
     }

     public User getUser(String userName, String password){
         User user = new User();
        try{
            FindUserLogic logic = new FindUserLogic();
            user = logic.findUser(userName, password);
        }catch(BusinessException e){
            e.printStackTrace();
        }catch(SystemException e){
            e.printStackTrace();
        }

        return user;
     }
}
