package com.zsn.factoryMode;

/**
 * @Author: zsn
 * @Date: 2024/2/6 11:17
 * @Description: 工厂模式
 * @Version: 1.0
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();
        Shape square = shapeFactory.getShape("Square");
        square.draw();

    }
}
