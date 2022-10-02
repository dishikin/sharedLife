package com.example.test.demo.Logic;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.test.demo.DAO.ConnectionManager;
import com.example.test.demo.DAO.UsersDAO;
import com.example.test.demo.Entity.User;

public class SignUpLogic{

    /**
     * Constructor without parameters
     */
    public SignUpLogic(){

    }

    public User signUp(User user) throws SystemException{
        Connection con = null;
        User newUser = null;

        try{
            con = ConnectionManager.getConnection();

            UsersDAO userDAO = new UsersDAO(con);
            newUser = userDAO.createUser(user);

        }catch(SQLException e){
            e.printStackTrace();
            throw new SystemException("System Error has occured. <br> Please contact the system manager.");
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
                throw new SystemException("System Error has occured. <br> Please contact the system manager.");
            }
        }

        return newUser;
    }
}