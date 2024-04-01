package edu.guilford;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class ControlController {

    private SimulationPane simulationPane;

    @FXML
    private Button addButton;

    @FXML
    private Slider attributeSlider;

    @FXML
    private ChoiceBox<?> choiceBox;

    

    public void setSimulationPane(SimulationPane simulationPane) {
        this.simulationPane = simulationPane;
    }


}
