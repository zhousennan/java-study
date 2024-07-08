package org.example.annotation;

import java.lang.annotation.Annotation;

/**
 * @Author: zsn
 * @Date: 2024/7/8 11:23
 * @Description: description of this class
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        Class stuClass = Class.forName("org.example.annotation.User");

        try {
            Object o = stuClass.getDeclaredConstructor().newInstance();
            User user = (User) o;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        TestAnnotation annotation = (TestAnnotation) stuClass.getAnnotation(TestAnnotation.class);


        if (annotation != null) {
            TestAnnotation testAnnotation = (TestAnnotation) annotation;
            System.out.println("value: " + testAnnotation.value());
        }

    }
}
