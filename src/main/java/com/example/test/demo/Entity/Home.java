package com.example.test.demo.Entity;

public class Home {
    /**
     * Initialising variables.
     * This class will be used to share information of the shared accomodation amongst the tenants.
     */
    private String homeName;
    private String address;
    private String rent;
    private String wifi;
    private String wifiPass;

    /**
     * Constructor without any arguments.
     */
    public Home(){

    }

    /**
     * Constructor with the below arguments. For a home without WiFi
     * @param homeName
     * @param address
     * @param rent
     */
    public Home(String homeName, String address, String rent) {
        this.homeName = homeName;
        this.address = address;
        this.rent = rent;
        this.wifi = null;
        this.wifiPass = null;
    }

    /**
     * Constructor with all arguments.
     * @param homeName
     * @param address
     * @param rent
     * @param wifi
     * @param wifiPass
     */
    public Home(String homeName, String address, String rent, String wifi, String wifiPass) {
        this.homeName = homeName;
        this.address = address;
        this.rent = rent;
        this.wifi = wifi;
        this.wifiPass = wifiPass;
    }

    //Below are getters and setters for the variables.
    
    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getWifiPass() {
        return wifiPass;
    }

    public void setWifiPass(String wifiPass) {
        this.wifiPass = wifiPass;
    }
    
    
}
