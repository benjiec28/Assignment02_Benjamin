package com.mycompany.assignment02_benjamin;

import java.util.Random;

public class Car {
    private static TYPE type;
    private String number;
    private int xPosition;
    private int yPosition;
    private COLOR color;
    private int speed;

    public Car(String number, int xPosition, int yPosition, COLOR color) {
        this.number = number;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }
    
    public static enum TYPE {
        CAR,
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

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void generateSpeed(Car car) {
        Random rand = new Random();
        this.speed = rand.nextInt(25);
        
        car.setSpeed(speed);
    }
}