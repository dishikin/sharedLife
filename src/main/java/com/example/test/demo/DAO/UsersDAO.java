package com.example.test.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.test.demo.Entity.User;

public class UsersDAO {
    /** Connect to DB */
    private Connection con;

    /**
     * Constructor
     * @param con DB connection
     */
    public UsersDAO(Connection con){
        this.con = con;
    }

    public Boolean checkPass(String userName, String password)throws SQLException{
        Boolean check = null;
        String sql = "SELECT userName, userPassword FROM user WHERE userName = ?";
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            res = stmt.executeQuery();

            if(res.next()){
                String pass = res.getString("userPassword");
                if(pass.equals(password)){
                    check = true;
                }else{
                    check = false;
                }
            }
        }catch(SQLException e){
            e.getStackTrace();
            throw e;
        }finally{
            if(res != null) {
                res.close();
            }
            if(stmt != null){
                stmt.close();
            }
        }

        return check;
    }

    /**
     * finding a user from the DB
     * @param userName
     * @param password
     * @return User
     * @throws SQLException
     */
    public User findUser(String userName, String password) throws SQLException{
        String sql = "SELECT * FROM user WHERE userName = ?";
        PreparedStatement stmt = null;
        ResultSet res = null;
        User user = null;
        Boolean hasGroup = null;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            res = stmt.executeQuery();

            
            if(res.next()){
                String p = res.getString("userPassword");
                System.out.println("userPassword: " + p);
                Boolean pass = password.equals(res.getString("userPassword"));
                System.out.println("userPassword is correct: " + pass);
                //Checking whether the user belongs to a group.
                hasGroup = res.getBoolean("hasGroup");
                System.out.println("hasGroup: " + hasGroup);

                if(pass){
                    //if the user doesn't belong to a group instantiate without group info
                    if(!hasGroup){
                        user = new User(
                            res.getInt("userID"),
                            res.getString("email"),
                            res.getString("userName"),
                            res.getString("userDOB"),
                            res.getString("userGen"),
                            res.getString("userNickName")
                        );
                }else{
                        user = new User(
                            res.getInt("userID"),
                            res.getString("email"),
                            res.getString("userName"),
                            res.getString("userDOB"),
                            res.getString("userGen"),
                            res.getInt("groupId"),
                            res.getBoolean("hasGroup"),
                            res.getString("userNickName")
                        );
                }
                }else{
                    return null;
                }
                    
                }
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            if(res != null) {
                res.close();
            }
            if(stmt != null){
                stmt.close();
            }
        }

        return user;
    }
}
