package com.mycompany.assignment02_benjamin;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CarRaceStartUpController {

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
}



 
