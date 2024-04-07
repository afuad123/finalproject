package edu.guilford;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

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
     * A button that adds a new plant to the simulation
     */
    private Button plantButton;

    @FXML
    /**
     * A button that adds a new plant eater to the simulation
     */
    private Button plantEaterButton;

    @FXML
    /**
     * A button that adds a new meat eater to the simulation
     */
    private Button meatEaterButton;


    /**
     * A textfield that contains the size of the plant object
     */
    @FXML
    private TextField plantSize;


    /**
     * A textfield that contains the rate of growth of the plant object
     */
    @FXML
    private TextField plantRate;

    /** 
     * A textfield that contains the size of the plant eater object
     */
    @FXML
    private TextField plantEaterSize;

    /**
     * A textfield that contains the rate of growth of the plant eater object
     */
    @FXML
    private TextField plantEaterRate;

    /** 
     * A textfield that contains the size of the meat eater object
     */
    @FXML
    private TextField meatEaterSize;

    /**
     * A textfield that contains the rate of growth of the meat eater object
     */
    @FXML
    private TextField meatEaterRate;
  
    /**
     * A setter for SimulationPane
     * @param simulationPane the new value of simulationPane
     */
    public void setSimulationPane(SimulationPane simulationPane) {
        this.simulationPane = simulationPane;
    }

    /**
     * A method that adds a new object to the simulation
     * @throws IOException
     */
    @FXML
    public void add() throws IOException {
        simulationPane.addCreature();
    }


}
