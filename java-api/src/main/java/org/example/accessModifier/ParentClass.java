package org.example.accessModifier;

/**
 * @Author: zsn
 * @Date: 2024/8/5 10:46
 * @Description: description of this class
 * @Version: 1.0
 *
 * public：
 * 类、成员变量、方法和构造方法都可以声明为 public。
 * public 成员可以从任何地方访问，包括其他包中的类。
 * protected：
 * 类本身不能声明为 protected。
 * protected 成员可以在同一包内访问，也可以被不同包中的子类访问。
 * 如果子类位于不同的包中，那么可以通过继承来访问父类中的 protected 成员。
 * default：
 * 类、成员变量、方法和构造方法都可以声明为 default（即不使用任何访问修饰符）。
 * default 成员只能在同一包内的类之间共享。
 * 如果类没有指定任何访问修饰符，那么它默认具有 default 访问级别。
 * private：
 * 类本身不能声明为 private。
 * private 成员只能在声明它们的类内部访问。
 * 即使是在同一个类中的其他方法也无法直接访问 private 成员，除非通过公共的方法
 */
// ParentClass.java
public class ParentClass {
    private int privateField;      // 私有字段
    int defaultField;             // 默认访问级别的字段
    protected int protectedField; // 受保护的字段
    public int publicField;       // 公共字段

    private void privateMethod() { // 私有方法
        System.out.println("This is a private method.");
    }

    void defaultMethod() {        // 默认访问级别的方法
        System.out.println("This is a default method.");
    }

    protected void protectedMethod() { // 受保护的方法
        System.out.println("This is a protected method.");
    }

    public void publicMethod() {  // 公共方法
        System.out.println("This is a public method.");
    }
}






