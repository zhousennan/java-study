package com.zsn.algorithm.disruptorTest.bean;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:18
 */
public class TestEvent {
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void update(User event){
       this.user.update(event);
    }
    //todo reset
    public void reset(User event){
        this.user.reset(event);
    }
}
