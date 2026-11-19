package com.mycompany.assignment02_benjamin;

import com.mycompany.assignment02_benjamin.Car.COLOR;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

    private static final String[] PLACE_NAMES = {"1st", "2nd", "3rd", "4th"};
    private static final double WHEEL_RADIUS = 7.0;
    private static final double WHEEL_SPIN_SECONDS = 0.6;
 
    private final CarRaceModel model = new CarRaceModel();
    private final Map<COLOR, Pane> carPanes = new EnumMap<>(COLOR.class);
    private final Map<Car, List<Group>> carWheels = new HashMap<>();
    private final Map<Car, List<RotateTransition>> carSpins = new HashMap<>();
    private Label[] placeNumberLabels;
    private Label[] placeColorLabels;
    private Label[] placeLabels;
 
    
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
        speedSlider.setValue(1.0);
        speed.setText("1.0x");

        Car yellowCarInfo = new Car("15", 0, 0, COLOR.YELLOW);
        Car greenCarInfo = new Car("28", 0, 0, COLOR.GREEN);
        Car blueCarInfo = new Car("42", 0, 0, COLOR.BLUE);
        Car redCarInfo = new Car("67", 0, 0, COLOR.RED);
        
        Pane cars[] = {yellowCar, greenCar, blueCar, redCar};
        Car carInfos[] = {yellowCarInfo, greenCarInfo, blueCarInfo, redCarInfo};
 
        placeNumberLabels = new Label[] {firstPlaceCar, secondPlaceCar, thirdPlaceCar, fourthPlaceCar};
        placeColorLabels = new Label[] {firstPlaceColor, secondPlaceColor, thirdPlaceColor, fourthPlaceColor};
        placeLabels = new Label[] {firstPlace, secondPlace, thirdPlace, fourthPlace};
 
        for (int i = 0; i < cars.length; i++) {
            Car carInfo = carInfos[i];
            model.addCar(carInfo);
            carPanes.put(carInfo.getColor(), cars[i]);
            createCar(cars[i]);
            cars[i].translateXProperty().addListener((obs, oldVal, newVal)
                    -> model.updatePosition(carInfo, newVal.doubleValue()));
        }
        
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
        Car carInfo = findCar(car);
        Color paint = toPaint(carInfo.getColor());
 
        Polygon carBody = new Polygon();
        
        carBody.getPoints().setAll(2.0, 28.0,
                                    83.0, 28.0,
                                    83.0, 19.0,
                                    72.0, 15.0,
                                    12.0, 15.0,
                                    2.0, 19.0
                                    );
               carBody.setFill(paint);
        carBody.setStroke(Color.BLACK);
 
        Polygon roof = new Polygon(20, 15, 30, 5, 56, 5, 66, 15);
        roof.setFill(paint.darker());
        roof.setStroke(Color.BLACK);
 
        Rectangle rearWindow = new Rectangle(31, 7, 11, 7);
        Rectangle frontWindow = new Rectangle(44, 7, 11, 7);
        rearWindow.setFill(Color.LIGHTSKYBLUE);
        frontWindow.setFill(Color.LIGHTSKYBLUE);
 
        Rectangle plate = new Rectangle(30, 16, 22, 11);
        plate.setFill(Color.WHITE);
 
        Text number = new Text(carInfo.getNumber());
        number.setFont(Font.font("Arial", FontWeight.BOLD, 9));
        number.setX(plate.getX() + (plate.getWidth() - number.getLayoutBounds().getWidth()) / 2);
        number.setY(plate.getY() + plate.getHeight() - 2);
 
        Rectangle tailLight = new Rectangle(2, 20, 4, 3);
        Rectangle headLight = new Rectangle(79, 20, 4, 3);
        tailLight.setFill(Color.ORANGE);
        headLight.setFill(Color.LIGHTYELLOW);
 
        Group rearWheel = createWheel(20, 29);
        Group frontWheel = createWheel(65, 29);
 
        car.getChildren().setAll(carBody, roof, rearWindow, frontWindow, plate,
                number, tailLight, headLight, rearWheel, frontWheel);
        carWheels.put(carInfo, Arrays.asList(rearWheel, frontWheel));
    }
    
    private Group createWheel(double centerX, double centerY) {
        Circle tire = new Circle(0, 0, WHEEL_RADIUS, Color.web("#98a0a6"));
        tire.setStroke(Color.BLACK);
        tire.setStrokeWidth(1.5);
 
        Line spoke = new Line(0, 0, 0, -(WHEEL_RADIUS - 1));
        spoke.setStroke(Color.BLACK);
 
        Group wheel = new Group(tire, spoke);
        wheel.setLayoutX(centerX);
        wheel.setLayoutY(centerY);
        return wheel;
    }
        
    private Color toPaint(COLOR color) {
        switch (color) {
            case YELLOW:
                return Color.web("#f7c60f");
            case GREEN:
                return Color.web("#1bac30");
            case BLUE:
                return Color.web("#1e79d6");
            case RED:
                return Color.web("#e01b1b");
            default:
                return Color.GRAY;
        }
    }
 
    private Car findCar(Pane pane) {
        for (Car carInfo : model.getCars()) {
            if (carPanes.get(carInfo.getColor()) == pane) {
                return carInfo;
            }
        }
        return null;
    }
    
    private List<RotateTransition> allWheelSpins() {
        List<RotateTransition> spins = new ArrayList<>();
        
        for (List<RotateTransition> carSpin : carSpins.values()) {
            spins.addAll(carSpin);
        }
        
        return spins;
    }
    
    public double generateTime() {
        time = 10.0 + rand.nextDouble() * 5.0;
        return time;
    }
        
    public void generateAnimation(Pane car) {
        Car carInfo = findCar(car);
        double raceTime = generateTime();
        model.assignRaceTime(carInfo, raceTime);
        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(car);
        translate.setFromX(0);
        translate.setToX(CarRaceModel.trackLength);
        translate.setDuration(Duration.seconds(raceTime));
        translate.setInterpolator(Interpolator.EASE_BOTH);
        translate.setOnFinished(event -> onCarFinished(carInfo));
        
        transitions.add(translate);
        translate.play();
        
        List<RotateTransition> spins = new ArrayList<>();
        for (Group wheel : carWheels.get(carInfo)) {
            RotateTransition spin = new RotateTransition(Duration.seconds(WHEEL_SPIN_SECONDS), wheel);
            spin.setByAngle(360);
            spin.setInterpolator(Interpolator.LINEAR);
            spin.setCycleCount(Animation.INDEFINITE);
            spins.add(spin);
            spin.play();
        }
        carSpins.put(carInfo, spins);
    }
    
       private void onCarFinished(Car carInfo) {
            model.recordFinish(carInfo);
            
            for (RotateTransition spin : carSpins.get(carInfo)) {
                spin.stop();
            }
            updateStats();

            if (model.isRaceFinished()) {
                getWinner();
                pauseButton.setDisable(true);
                speedSlider.setDisable(true);
            }
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
            
            for (RotateTransition spin : allWheelSpins()) {
                spin.pause();
            }
            pauseButton.setText("RESUME");
            speedSlider.setDisable(true);

        } else {
            for (TranslateTransition t : transitions) {
                if (t.getStatus() == Animation.Status.PAUSED) {
                    t.play(); 
                }
            }
            
            for (RotateTransition spin : allWheelSpins()) {
                if (spin.getStatus() == Animation.Status.PAUSED) {
                    spin.play();
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
        
        for (RotateTransition spin : allWheelSpins()) {
            spin.stop();
        }
        carSpins.clear();
        
        yellowCar.setTranslateX(0);
        greenCar.setTranslateX(0);
        blueCar.setTranslateX(0);
        redCar.setTranslateX(0);
    
        for (List<Group> wheels : carWheels.values()) {
            for (Group wheel : wheels) {
                wheel.setRotate(0);
            }
        }
        model.reset();
        
        pauseButton.setText("PAUSE");
        startButton.setDisable(false);
        pauseButton.setDisable(true);
        resetButton.setDisable(true);
        speedSlider.setDisable(true);
        
        speedSlider.setValue(1.0); 
    }

    @FXML
    void start(MouseEvent event) {
        model.prepareRace();
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