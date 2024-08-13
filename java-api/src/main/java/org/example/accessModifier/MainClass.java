package org.example.accessModifier;

/**
 * @Author: zsn
 * @Date: 2024/8/5 10:55
 * @Description: description of this class
 * @Version: 1.0
 */
public class MainClass {


    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        ChildClass child = new ChildClass();

        // 访问父类的不同访问级别的成员
        System.out.println("Accessing fields from ParentClass:");
        // System.out.println("Private field: " + parent.privateField); // 编译错误
        // System.out.println("Default field: " + parent.defaultField); // 编译错误
        // System.out.println("Protected field: " + parent.protectedField); // 编译错误
        System.out.println("Public field: " + parent.publicField); // 可以访问

        System.out.println("\nAccessing methods from ParentClass:");
        // parent.privateMethod(); // 编译错误
        parent.defaultMethod(); // 编译错误
        parent.protectedMethod(); // 编译错误
        parent.publicMethod(); // 可以访问

        // 访问子类的方法
        child.accessParentFieldsAndMethods();
    }
}
