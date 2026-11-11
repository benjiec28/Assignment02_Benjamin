package com.mycompany.assignment02_benjamin;

import java.io.IOException;
import javafx.fxml.FXML;

public class CarRaceStartUpController {
    
    @FXML
    private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
    }
}
