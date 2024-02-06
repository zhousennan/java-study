package com.zsn.factoryMode;

/**
 * @Author: zsn
 * @Date: 2024/2/6 11:15
 * @Description: 工厂模式
 * @Version: 1.0
 */
public class ShapeFactory {
    public  Shape getShape(String shapeType)
    {
        Shape shape = null;
        if(shapeType == null)
        {
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE"))
        {
            shape = new Circle();
        }
        else if(shapeType.equalsIgnoreCase("RECTANGLE"))
        {
            shape = new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE"))
        {
            shape = new Square();
        }
        return shape;
    }
}
