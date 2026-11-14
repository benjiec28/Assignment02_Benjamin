package com.mycompany.assignment02_benjamin;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CarRaceStartUpController implements Initializable {

    @FXML
    private ImageView blueCar;

    @FXML
    private Button enterButton;

    @FXML
    private Button exitButton;

    @FXML
    private ImageView greenCar;

    @FXML
    private ImageView redCar;

    @FXML
    private Label welcomeLabel;

    @FXML
    private ImageView yellowCar;

    @FXML
    void enter(MouseEvent event) throws IOException {
        App.setRoot("CarRaceFXML");
        
    }

    @FXML
    void exit(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Image yellowCarIMG = new Image("file:car_15_yellow.png");
    yellowCar = new ImageView(yellowCarIMG);
    
    FadeTransition yellowFade = new FadeTransition(new Duration(3000), yellowCar);
    yellowFade.setFromValue(1.0);
    yellowFade.setToValue(0.25);
    yellowFade.play();
    
    Image greenCarIMG = new Image("file:car_28_green.png");
    greenCar = new ImageView(greenCarIMG);
    
    FadeTransition greenFade = new FadeTransition(new Duration(3000), greenCar);
    greenFade.setFromValue(1.0);
    greenFade.setToValue(0.25);
    greenFade.play();
    
    Image blueCarIMG = new Image("file:car_42_blue.png");
    blueCar = new ImageView(blueCarIMG);
    
    FadeTransition blueFade = new FadeTransition(new Duration(3000), blueCar);
    blueFade.setFromValue(1.0);
    blueFade.setToValue(0.25);
    blueFade.play();
    
    Image redCarIMG = new Image("file:car_67_red.png");
    redCar = new ImageView(redCarIMG);
    
    FadeTransition redFade = new FadeTransition(new Duration(3000), redCar);
    redFade.setFromValue(1.0);
    redFade.setToValue(0.25);
    redFade.play();
    
    SequentialTransition slideShow = new SequentialTransition(yellowFade, greenFade, blueFade, redFade);
    slideShow.playFromStart();
    
    }
}



 
