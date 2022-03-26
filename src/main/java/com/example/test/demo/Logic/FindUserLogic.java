package com.example.test.demo.Logic;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.test.demo.DAO.ConnectionManager;
import com.example.test.demo.DAO.UsersDAO;
import com.example.test.demo.Entity.User;

public class FindUserLogic {
    /**
     * Function for finding a user.
     * @param userNAme
     * @param password
     * @return User
     * @throws SQLException
     * 
     */
    public User findUser(String userName, String password) throws BusinessException, SystemException{
        Connection con = null;
        User user = null;

        try{
            con = ConnectionManager.getConnection();

            UsersDAO userDAO = new UsersDAO(con);
            user = userDAO.findUser(userName, password);

            if(user == null){
                throw new BusinessException("There is no user with the set of information you gave us.");
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
        return user;
    }
}
