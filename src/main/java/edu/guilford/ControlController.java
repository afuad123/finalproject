package edu.guilford;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

/**
 * A class that generates the control window that controls the simulation.
 * @Author A. Fuad
 * @Version 4/7/24
 * @See SimulationPane
 * @See SimulationModel
 */

public class ControlController {


    /**
     * A reference to the simulation pane that is controlled by this controller
     */
    private SimulationPane simulationPane;

    @FXML
    /**
     * A button that adds a new creature to the simulation
     */
    private Button addButton;

    @FXML
    /**
     * A slider that changes the amount of objects to add
     */
    private Slider attributeSlider;

    @FXML
    /**
     * A choicebox that allows the user to choose the type of object to add
     */
    private ChoiceBox<?> choiceBox;

    
    /**
     * A setter for SimulationPane
     * @param simulationPane the new value of simulationPane
     */
    public void setSimulationPane(SimulationPane simulationPane) {
        this.simulationPane = simulationPane;
    }


}
