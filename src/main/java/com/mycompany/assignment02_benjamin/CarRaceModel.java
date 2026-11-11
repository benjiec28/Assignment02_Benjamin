package com.mycompany.assignment02_benjamin;

import java.io.IOException;
import javafx.fxml.FXML;

public class CarRaceModel {
    private static TYPE type;
    private int number;
    private int xPosition;
    private int yPosition;
    private COLOR color;
    
    
    public static enum TYPE {
        CAR,
        RACECAR,
        
    }
    
    public static enum COLOR {
        BLUE,
        RED,
        GREEN,
        YELLOW,
        
    }
}