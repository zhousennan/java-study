package org.example.reflex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public static void main(String[] args) {
        String s = new String("abc");
        String s1 = new String("abc");
        HashSet<String> set = new HashSet<>();

        Map<String, String> map = new HashMap<>();

        map.put("a", "a");
        map.entrySet().stream().forEach(System.out::println);
        System.out.println(set.add(s));
        System.out.println(set.add(s1));
        System.out.println(s==s1);
        System.out.println(set.size());
    }
}
