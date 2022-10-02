package com.example.test.demo.Logic;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.test.demo.DAO.ConnectionManager;
import com.example.test.demo.DAO.UsersDAO;


public class CheckUserExistLogic {
    public CheckUserExistLogic(){

    }   
    
    public Boolean checkUserExist(String username)throws BusinessException, SystemException{
        Boolean userExist = true;
        Connection con = null;
        
        try{
            con = ConnectionManager.getConnection();

            UsersDAO userDAO = new UsersDAO(con);
            userExist = userDAO.checkUserExistDAO(username);

            if(userExist == true){
                throw new BusinessException("The username you gave us already exists. <br> Please try again with a different username");
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SystemException("System error has occured. <br> Please contact the system manager.");
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
                throw new SystemException("System error has occured. <br> Please contact the system manager.");
            }
        }
        return userExist;
    }
}
