package com.onssoftware.DesignPatterns.Creational.FactoryPattern;

public class FactoryPattern {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape(ShapeNames.Rectangle.toString()).draw();
        shapeFactory.getShape(ShapeNames.Square.toString()).draw();
        shapeFactory.getShape(ShapeNames.Circle.toString()).draw();
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
    public Shape getShape(String shapeType) {

        /*if (shapeType == null) {
            return null;
        }*/

        switch (shapeType) {
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

enum ShapeNames {
    Rectangle, Square, Circle
}