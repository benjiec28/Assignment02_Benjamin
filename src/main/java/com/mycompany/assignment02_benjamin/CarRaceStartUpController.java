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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

    private MediaPlayer player;
    
    /**
     * Enter the game Window (CarRaceFXML).
     * @param event the mouse click.
     * @throws IOException the IOexception.
     */
    @FXML
    void enter(MouseEvent event) throws IOException {
        stopMusic();
        App.setRoot("CarRaceFXML");
    }

    /**
     * Exits the app.
     * @param event the mouse click.
     */
    @FXML
    void exit(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yellowCar.setOpacity(0);
        greenCar.setOpacity(0);
        blueCar.setOpacity(0);
        redCar.setOpacity(0); 

        yellowCar.setImage(new Image(getClass().getResourceAsStream("/images/car_15_yellow.png")));

        FadeTransition yellowFadeIN = new FadeTransition(new Duration(1500), yellowCar);
        yellowFadeIN.setFromValue(0);
        yellowFadeIN.setToValue(1);

        FadeTransition yellowFadeOUT = new FadeTransition(new Duration(1500), yellowCar);
        yellowFadeOUT.setFromValue(1);
        yellowFadeOUT.setToValue(0);

        greenCar.setImage(new Image(getClass().getResourceAsStream("/images/car_28_green.png")));

        FadeTransition greenFadeIN = new FadeTransition(new Duration(1500), greenCar);
        greenFadeIN.setFromValue(0);
        greenFadeIN.setToValue(1);

        FadeTransition greenFadeOUT = new FadeTransition(new Duration(1500), greenCar);
        greenFadeOUT.setFromValue(1);
        greenFadeOUT.setToValue(0);

        blueCar.setImage(new Image(getClass().getResourceAsStream("/images/car_42_blue.png")));

        FadeTransition blueFadeIN = new FadeTransition(new Duration(1500), blueCar);
        blueFadeIN.setFromValue(0);
        blueFadeIN.setToValue(1);

        FadeTransition blueFadeOUT = new FadeTransition(new Duration(1500), blueCar);
        blueFadeOUT.setFromValue(1);
        blueFadeOUT.setToValue(0);

        redCar.setImage(new Image(getClass().getResourceAsStream("/images/car_67_red.png")));

        FadeTransition redFadeIN = new FadeTransition(new Duration(1500), redCar);
        redFadeIN.setFromValue(0);
        redFadeIN.setToValue(1);

        FadeTransition redFadeOUT = new FadeTransition(new Duration(1500), redCar);
        redFadeOUT.setFromValue(1);
        redFadeOUT.setToValue(0);


        SequentialTransition slideShow = new SequentialTransition(yellowFadeIN, yellowFadeOUT, greenFadeIN, greenFadeOUT, blueFadeIN, blueFadeOUT, redFadeIN, redFadeOUT);
        slideShow.setCycleCount(SequentialTransition.INDEFINITE);
        slideShow.playFromStart();
        playMusic();
    }
    
    /**
     * Plays the music.
     */
    private void playMusic() {
        Media media = new Media(getClass().getResource("/sounds/guitar.wav").toExternalForm());
        player = new MediaPlayer(media);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.setAutoPlay(true);
        
    }
    
    /**
     * Stops the music.
     */
    private void stopMusic() {
        if (player != null) {
            player.stop();
            player.dispose();
        }
    }
}