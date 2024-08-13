package org.example.accessModifier;

/**
 * @Author: zsn
 * @Date: 2024/8/5 10:56
 * @Description: description of this class
 * @Version: 1.0
 */
 class ChildClass extends ParentClass {


    public void accessParentFieldsAndMethods() {
        // 访问父类的不同访问级别的成员
        System.out.println("Accessing fields:");
        //System.out.println("Private field: " + privateField); // 编译错误
        //  System.out.println("Default field: " + defaultField); // 编译错误
        System.out.println("Protected field: " + protectedField); // 可以访问
        System.out.println("Public field: " + publicField); // 可以访问

        System.out.println("\nAccessing methods:");
        //privateMethod(); // 编译错误
        defaultMethod(); // 编译错误
        protectedMethod(); // 可以访问
        publicMethod(); // 可以访问
    }
}
