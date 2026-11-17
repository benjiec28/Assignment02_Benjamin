package com.mycompany.assignment02_benjamin;

import java.util.Random;
import javafx.scene.layout.Pane;

public class Car {
    private static TYPE type;
    private String number;
    private int xPosition;
    private int yPosition;
    private COLOR color;
    private double time;

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

    public void setColor(COLOR color) {
        this.color = color;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}