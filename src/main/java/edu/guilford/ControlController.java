package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * A class that generates the control window that controls the simulation.
 * @author A. Fuad
 * @version 4/7/24
 * @see SimulationPane
 * @see SimulationModel
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
     * A button that clears the SimulationPane
     */
    private Button clearButton;

    @FXML
    /**
     * A button that restarts the Simulation
     */
    private Button restartButton;

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

    @FXML
    /**
     * A button that adds a new human the simulation
     */
    private Button humanButton;

    /**
     * A button that makes a plant eater object chew a plant object
     */
    @FXML
    private Button chewButton;

    /**
     * A button that makes a meat eater object eat a plant eater object
     */
    @FXML
    private Button eatButton;

    /**
     * A button that makes a human object hunt
     */
    @FXML
    private Button huntButton;

    /**
     * A button that allows the user to simulate a day in the simulation
     */
    @FXML 
    private Button simulateDayButton;

    /**
     * A button that allows the user to view plant stats after simulating a day
     */
    @FXML
    private Button plantStatsButton;

    /**
     * A button that allows the user to view plant eater stats after simulating a day
     */
    @FXML
    private Button plantEaterStatsButton;

    /**
     * A button that allows the user to view meat eater stats after simulating a day
     */
    @FXML
    private Button meatEaterStatsButton;

    /**
     * A button that allows the user to view human stats after simulating a day
     */
    @FXML
    private Button humanStatsButton;

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
     * A textfield that contains the size of the human object
     */
    @FXML
    private TextField humanSize;

    /**
     * A textfield that contains the rate of growth of the human object
    */
    @FXML
    private TextField humanRate;
  
    /**
     * A setter for SimulationPane
     * @param simulationPane the new value of simulationPane
     */
    public void setSimulationPane(SimulationPane simulationPane) {
        this.simulationPane = simulationPane;
    }

    /**
     * A setter for SimulationModel
     * @param model the new value of model
     */
    public void setModel(SimulationModel model) {
        this.model = model;
    }

    /**
     * A method that clears the pane of text
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void clearPane() {
        simulationPane.getChildren().clear();
    }
    /**
     * A method that restarts the simulation 
     * @param e the event that triggers the method (a button click)
     */
    @FXML 
    public void restartSimulation() {
        simulationPane.restart(model);
        simulationPane.getChildren().clear();
    }

    /**
     * A method that adds a new plant object to the simulation
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void submitPlant() {
        float size = Float.parseFloat(plantSize.getText());
        float rate = Float.parseFloat(plantRate.getText());
        simulationPane.addPlant(size, rate, model);
    }

    /**
     * A method that adds a new plant eater object to the simulation
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void submitPlantEater() {
        float size = Float.parseFloat(plantEaterSize.getText());
        float rate = Float.parseFloat(plantEaterRate.getText());
        simulationPane.addPlantEater(size, rate, model);
    }

    /**
     * A method that adds a new meat eater object to the simulation
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void submitMeatEater() {
        float size = Float.parseFloat(meatEaterSize.getText());
        float rate = Float.parseFloat(meatEaterRate.getText());
        simulationPane.addMeatEater(size, rate, model);
    }

    /**
     * A method that adds a new human object to the simulation
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void submitHuman() {
        float size = Float.parseFloat(humanSize.getText());
        float rate = Float.parseFloat(humanRate.getText());
        simulationPane.addHuman(size, rate, model);
    }

    /**
     * A method that makes the simulation experience a day
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void simulateDay() {
        simulationPane.simulateDay(model);
    }

    /**
     * A method that allows the user to view the stats of the plant objects after simulating a day
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void viewPlantStats() {
        simulationPane.plantStats(model);
    }

    /**
     * A method that allows the user to view the stats of the plant eater objects after simulating a day
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void viewPlantEaterStats() {
        simulationPane.plantEaterStats(model);
    }

    /**
     * A method that allows the user to view the stats of the meat eater objects after simulating a day
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void viewMeatEaterStats() {
        simulationPane.meatEaterStats(model);
    }

    /**
     * A method that allows the user to view the stats of the human objects after simulating a day
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void viewHumanStats() {
        simulationPane.humanStats(model);
    }

    /**
     * A method that makes a plant eater object chew a plant object
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void chew() {
        simulationPane.chew(model);
    }

    /**
     * A method that makes a meat eater object eat a plant eater object
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void eat() {
        simulationPane.eat(model);
    }

    /**
     * A method that makes a human object hunt
     * @param e the event that triggers the method (a button click)
     */
    @FXML
    public void hunt() {
        simulationPane.hunt(model);
    }

    

}
