package org.example.reflex;

/**
 * @Author: zsn
 * @Date: 2024/7/8 14:11
 * @Description: description of this class
 * @Version: 1.0
 */
public class TestUser {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
