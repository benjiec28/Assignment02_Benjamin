package com.mycompany.assignment02_benjamin;

import com.mycompany.assignment02_benjamin.Car.COLOR;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

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
    private Button exitButton;
      
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
    private Button returnButton;

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

    private double time;
    private final List<TranslateTransition> transitions = new ArrayList<>();
    private final Random rand = new Random();
    private int length = 490;

    
    @FXML
    void exit(MouseEvent event) {
        Platform.exit();
    }
    
    @FXML
    void returnToStartUp(MouseEvent event) throws IOException {
        App.setRoot("CarRaceStartUp");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pauseButton.setDisable(true);
        resetButton.setDisable(true);
        speedSlider.setDisable(true);

        Car yellowCarInfo = new Car("15", 0, 0, COLOR.YELLOW);
        Car greenCarInfo = new Car("28", 0, 0, COLOR.GREEN);
        Car blueCarInfo = new Car("42", 0, 0, COLOR.BLUE);
        Car redCarInfo = new Car("67", 0, 0, COLOR.RED);
        
        Pane cars[] = {yellowCar, greenCar, blueCar, redCar};
        
        speedSlider.valueProperty().addListener((ov, oldVal, newVal) -> {
             double speedFactor = newVal.doubleValue();
        
        if (speedFactor <= 0.1) {
            speedFactor = 0.1;
        }

        speed.setText(String.format("%.1fx", speedFactor));

        double calculatedRate = speedFactor / 1;
        for (TranslateTransition transition : transitions) {
            transition.setRate(calculatedRate);
        }
    });
    }
    
    public void createCar(Pane car) {
        Polygon carBody = new Polygon();
        carBody.getPoints().setAll(7.0, 25.0,
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
    
    public double generateTime() {
        time = 10.0 + rand.nextDouble() * 5.0;
        return time;
    }
        
    public void generateAnimation(Pane car) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(car);
        translate.setFromX(0);
        translate.setToX(435);
        translate.setDuration(Duration.seconds(generateTime()));
        translate.setInterpolator(Interpolator.EASE_BOTH);
        
        transitions.add(translate);
        translate.play();
    }
        
    public void updateStats() {
        
    }
    
    public void getWinner() {
        
    }
    
    @FXML
    void pause(MouseEvent event) {
        if (transitions.isEmpty()) {
            return;
        }

        if (pauseButton.getText().equals("PAUSE")) {
            for (TranslateTransition t : transitions) {
                t.pause();
            }
            pauseButton.setText("RESUME");
            speedSlider.setDisable(true);

        } else {
            for (TranslateTransition t : transitions) {
                if (t.getStatus() == Animation.Status.PAUSED) {
                    t.play(); 
                }
            }
            pauseButton.setText("PAUSE");
            speedSlider.setDisable(false);
        }
    }

    @FXML
    void reset(MouseEvent event) {
        for (TranslateTransition t : transitions) {
            t.stop();
        }
        transitions.clear();
        
        yellowCar.setTranslateX(0);
        greenCar.setTranslateX(0);
        blueCar.setTranslateX(0);
        redCar.setTranslateX(0);
        
        pauseButton.setText("PAUSE");
        startButton.setDisable(false);
        pauseButton.setDisable(true);
        resetButton.setDisable(true);
        speedSlider.setDisable(true);
        
        speedSlider.setValue(1.0); 
    }

    @FXML
    void speedChange(MouseEvent event) {

    }

    @FXML
    void start(MouseEvent event) {
        generateAnimation(yellowCar);
        generateAnimation(greenCar);
        generateAnimation(blueCar);
        generateAnimation(redCar);
        
        startButton.setDisable(true);
        pauseButton.setDisable(false);
        resetButton.setDisable(false);
        speedSlider.setDisable(false);
    }

}