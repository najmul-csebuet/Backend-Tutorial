package com.onssoftware.DesignPatterns.Creational.Factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape(ShapeType.Rectangle).draw();
        shapeFactory.getShape(ShapeType.Square).draw();
        shapeFactory.getShape(ShapeType.Circle).draw();
    }
}

interface Shape {
    void draw();
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

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class ShapeFactory {

    public Shape getShape(ShapeType shapeType) {

        switch (shapeType.toString()) {
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            case "Circle":
                return new Circle();
        }

        return null;
    }
}

enum ShapeType {
    Rectangle, Square, Circle
}
