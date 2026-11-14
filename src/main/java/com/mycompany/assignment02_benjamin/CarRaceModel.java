package com.mycompany.assignment02_benjamin;

public class CarRaceModel {
    private static TYPE type;
    private int number;
    private int xPosition;
    private int yPosition;
    private COLOR color;
    
    
    public static enum TYPE {
        CAR,
    }
    
    public static enum COLOR {
        BLUE,
        RED,
        GREEN,
        YELLOW,
    }
}