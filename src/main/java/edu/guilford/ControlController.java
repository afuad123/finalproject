package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    /**
     * A reference to the simulation model that is controlled by this controller
     */
    private SimulationModel model;

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

    @FXML
    private Label testLabel;
  
    /**
     * A setter for SimulationPane
     * @param simulationPane the new value of simulationPane
     */
    public void setSimulationPane(SimulationPane simulationPane) {
        this.simulationPane = simulationPane;
    }

    public void setModel(SimulationModel model) {
        this.model = model;
    }

    // /**
    //  * A method that initializes the control window
    //  */
    // @FXML
    // public void initialize() {
    //     plantButton.setOnAction(e -> {
    //         simulationPane.addPlant(Integer.parseInt(plantSize.getText()), Integer.parseInt(plantRate.getText()));
    //     });

    //     plantEaterButton.setOnAction(e -> {
    //         simulationPane.addPlantEater(Integer.parseInt(plantEaterSize.getText()), Integer.parseInt(plantEaterRate.getText()));
    //     });

    //     meatEaterButton.setOnAction(e -> {
    //         simulationPane.addMeatEater(Integer.parseInt(meatEaterSize.getText()), Integer.parseInt(meatEaterRate.getText()));
    //     });
    // }

    @FXML
    public void submitPlant() {
        float size = Float.parseFloat(plantSize.getText());
        float rate = Float.parseFloat(plantRate.getText());
        simulationPane.addPlant(size, rate, model);
        testLabel.setText("Plant added");
    }

    @FXML
    public void submitPlantEater() {
        float size = Float.parseFloat(plantEaterSize.getText());
        float rate = Float.parseFloat(plantEaterRate.getText());
        simulationPane.addPlantEater(size, rate, model);
        testLabel.setText("Plant eater added");
    }

    @FXML
    public void submitMeatEater() {
        float size = Float.parseFloat(meatEaterSize.getText());
        float rate = Float.parseFloat(meatEaterRate.getText());
        simulationPane.addMeatEater(size, rate, model);
        testLabel.setText("Meat eater added");
    }

    

}
