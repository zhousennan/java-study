package org.example.reflex;

import org.example.annotation.TestAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: zsn
 * @Date: 2024/7/8 14:11
 * @Description: description of this class
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args)   {
        // 1 通过类名获取 Class 对象
        Class<TestUser> userClass = TestUser.class;

        try {
            // 2 获取构造器和创建实例
            TestUser testUser = userClass.getDeclaredConstructor().newInstance();
            //3获取方法和调用
            Method setName = userClass.getMethod("setName", String.class);
            //调用方法
            setName.invoke(testUser,"zsn");

            // 4获取和设置字段
            //只能访问公共 (public) 字段。如果目标字段是私有 (private)、受保护 (protected) 或默认访问级别，并且不在同一个包内，则 getField() 无法找到该字段。
            //Field name = userClass.getField("age");
            //使用 getDeclaredField() 方法时，可以访问所有声明的字段，无论访问级别如何。但是，如果字段是在父类或接口中声明的，那么在当前类中将不会被找到。
            Field age = userClass.getDeclaredField("age");
            age.setAccessible(true);
            age.set(testUser,1);
            //  5检查类型和继承关系
            if (userClass.isAssignableFrom(Test.class)) {
                System.out.println("MyOtherClass can be cast to MyClass");
            }
           // 6. 获取注解
            TestAnnotation annotation = userClass.getAnnotation(TestAnnotation.class);

            System.out.println(testUser.toString());

        }catch (Exception noSuchMethodException){

            System.out.println("=====Exception======");
        }


    }
}
