package com.example.test.demo.Entity;
import java.util.*;

public class Group {
    private int groupID;
    private String groupName;
    private ArrayList<String> groupMembers;
    private String address;

    public Group(){

    }

    public Group(int groupID, String groupName, ArrayList<String> groupMembers, String address){
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupMembers = groupMembers;
        this.address = address;
    }

    public void setGroupID(int groupID){
        this.groupID = groupID;
    }

    public int getGrouID(){
        return groupID;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupMembers(ArrayList<String> groupMembers){
        this.groupMembers = groupMembers;
    }

    public ArrayList<String> getGroupMembers(){
        return groupMembers;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public String getAddress(){
        return address;
    }

}
