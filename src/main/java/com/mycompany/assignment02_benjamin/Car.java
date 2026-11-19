package com.mycompany.assignment02_benjamin;

public class Car {
    private static TYPE type;
    private String number;
    private double xPosition;
    private double yPosition;
    private COLOR color;
    private double speed;
    private double time;

    public Car(String number, double xPosition, double yPosition, COLOR color) {
        this.number = number;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }
    
    public static enum TYPE {
        SEDAN
    }
    
    public static enum COLOR {
        BLUE,
        RED,
        GREEN,
        YELLOW,
    }

    public static TYPE getType() {
            return type;
    }
 
    public static void setType(TYPE type) {
        Car.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}