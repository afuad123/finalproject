package edu.guilford;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControlController {

    @FXML
    private void switchToSecondary() throws IOException {
        CreatureDriver.setRoot("secondary");
    }
}
