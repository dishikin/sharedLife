package com.example.test.demo.Logic;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.test.demo.DAO.ConnectionManager;
import com.example.test.demo.DAO.UsersDAO;

public class CheckPassLogic {
    
    public CheckPassLogic(){

    }

    public Boolean checkPass(String userName, String password)throws BusinessException, SystemException{
        Boolean check = null;
        Connection con = null;

        try{
            con = ConnectionManager.getConnection();
            UsersDAO userDAO = new UsersDAO(con);
            check = userDAO.checkPass(userName, password);

            if(check == null || check == false){
                throw new BusinessException("The Username or password you entered is incorrect. Please try again.");
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
        
        return check;
    }
}
