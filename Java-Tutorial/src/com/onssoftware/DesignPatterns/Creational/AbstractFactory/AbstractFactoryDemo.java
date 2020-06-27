package com.onssoftware.DesignPatterns.Creational.AbstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        boolean rounded = false;
        AbstractFactory shapeFactory = FactoryProducer.getFactory(rounded);

        shapeFactory.getShape(ShapeType.RECTANGLE).draw();
        shapeFactory.getShape(ShapeType.SQUARE).draw();

        rounded = true;
        shapeFactory = FactoryProducer.getFactory(rounded);
        shapeFactory.getShape(ShapeType.Rounded_RECTANGLE).draw();
        shapeFactory.getShape(ShapeType.Rounded_SQUARE).draw();
    }
}

interface D {}
interface D1 {}

interface Shape extends D, D1 {
    int h = 0;
    static void dd() {

    }

    default void s() {

    }

    void draw();
}

class RoundedRectangle implements Shape {

    @Override
    public void draw() {
        s();
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}

class RoundedSquare implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

enum ShapeType {
    RECTANGLE, SQUARE, Rounded_RECTANGLE, Rounded_SQUARE
}

abstract class AbstractFactory {
    abstract Shape getShape(ShapeType shapeType);
}

class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(ShapeType shapeType) {
        if (shapeType.equals(ShapeType.RECTANGLE))return new Rectangle();
        if (shapeType.equals(ShapeType.SQUARE))return new Square();
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(ShapeType shapeType) {
        if (shapeType.equals(ShapeType.Rounded_RECTANGLE))return new RoundedRectangle();
        if (shapeType.equals(ShapeType.Rounded_SQUARE))return new RoundedSquare();
        return null;
    }
}

class FactoryProducer {

    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded)return new RoundedShapeFactory();
        return new ShapeFactory();
    }
}