package com.mycompany.assignment02_benjamin;

import com.mycompany.assignment02_benjamin.Car.COLOR;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class CarRaceController implements Initializable {


    @FXML
    private Pane redCar;

    @FXML
    private Pane blueCar;

    @FXML
    private Polygon carBody1;

    @FXML
    private Polygon carBody2;

    @FXML
    private Polygon carBody3;

    @FXML
    private Polygon carBody4;

    @FXML
    private Label congratulationMsg;

    @FXML
    private Label firstPlace;

    @FXML
    private Label firstPlaceCar;

    @FXML
    private Label firstPlaceColor;

    @FXML
    private Label fourthPlace;

    @FXML
    private Label fourthPlaceCar;

    @FXML
    private Label fourthPlaceColor;

    @FXML
    private Pane greenCar;

    @FXML
    private Button pauseButton;

    @FXML
    private Label raceFinishedMsg;

    @FXML
    private Button resetButton;

    @FXML
    private Label secondPlace;

    @FXML
    private Label secondPlaceCar;

    @FXML
    private Label secondPlaceColor;

    @FXML
    private Label speed;

    @FXML
    private Slider speedSlider;

    @FXML
    private Button startButton;

    @FXML
    private Label thirdPlace;

    @FXML
    private Label thirdPlaceCar;

    @FXML
    private Label thirdPlaceColor;

    @FXML
    private Pane yellowCar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Car yellowCarInfo = new Car("15", 0, 0, COLOR.YELLOW);
        Car greenCarInfo = new Car("28", 0, 0, COLOR.GREEN);
        Car blueCarInfo = new Car("42", 0, 0, COLOR.BLUE);
        Car redCarInfo = new Car("67", 0, 0, COLOR.RED);
        
        Pane cars[] = {yellowCar, greenCar, blueCar, redCar};
        carBody1.getPoints().setAll(7.0, 25.0,
                                    80.0, 25.0,
                                    80.0, 12.0,
                                    65.0, 12.0,
                                    65.0, 3.0,
                                    35.0, 3.0,
                                    35.0, 12.0,
                                    7.0, 12.0,
                                    7.0, 25.0
                                    );
    }
    
    public void createCar() {

    }
    
    public void generateAnimation() {
        
    }
        
    public void updateStats() {
        
    }
    
    public void getWinner() {
        
    }
    

    
    @FXML
    void pause(MouseEvent event) {

    }

    @FXML
    void reset(MouseEvent event) {

    }

    @FXML
    void speedChange(MouseEvent event) {

    }

    @FXML
    void start(MouseEvent event) {

    }

}