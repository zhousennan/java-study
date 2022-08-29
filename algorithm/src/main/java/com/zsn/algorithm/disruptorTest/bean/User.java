package com.zsn.algorithm.disruptorTest.bean;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:15
 */
public class User {
    private String userName;
    private String password;
    private String address;

    public User() {
    }

    public User(String userName, String password, String address) {
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void update(User user){
        this.userName = user.userName;
        this.password = user.password;
        this.address = user.address;
    }
    public void reset(User user){
        this.userName = "";
        this.password = "";
        this.address = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
