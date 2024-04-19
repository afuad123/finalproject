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

    /**
     * A constructor that initializes the control controller
     */
    public ControlController() {
    }

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
     */
    @FXML
    public void clearPane() {
        simulationPane.getChildren().clear();
    }
    /**
     * A method that restarts the simulation 
     */
    @FXML 
    public void restartSimulation() {
        simulationPane.restart(model);
        simulationPane.getChildren().clear();
    }

    /**
     * A method that adds a new plant object to the simulation
     */
    @FXML
    public void submitPlant() {
        float size = Float.parseFloat(plantSize.getText());
        float rate = Float.parseFloat(plantRate.getText());
        try {
            if (size < 0 || rate < 0) {
                throw new NegativeNumberException("Size and rate must be positive");
            }
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        simulationPane.addPlant(size, rate, model);
        }
    

    /**
     * A method that adds a new plant eater object to the simulation
     */
    @FXML
    public void submitPlantEater() {
        float size = Float.parseFloat(plantEaterSize.getText());
        float rate = Float.parseFloat(plantEaterRate.getText());
        try {
            if (size < 0 || rate < 0) {
                throw new NegativeNumberException("Size and rate must be positive");
            }
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        simulationPane.addPlantEater(size, rate, model);
    }

    /**
     * A method that adds a new meat eater object to the simulation
     */
    @FXML
    public void submitMeatEater() {
        float size = Float.parseFloat(meatEaterSize.getText());
        float rate = Float.parseFloat(meatEaterRate.getText());
        try {
            if (size < 0 || rate < 0) {
                throw new NegativeNumberException("Size and rate must be positive");
            }
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        simulationPane.addMeatEater(size, rate, model);
    }

    /**
     * A method that adds a new human object to the simulation
     */
    @FXML
    public void submitHuman() {
        float size = Float.parseFloat(humanSize.getText());
        float rate = Float.parseFloat(humanRate.getText());
        try {
            if (size < 0 || rate < 0) {
                throw new NegativeNumberException("Size and rate must be positive");
            }
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        simulationPane.addHuman(size, rate, model);
    }

    /**
     * A method that makes the simulation experience a day
     */
    @FXML
    public void simulateDay() {
        simulationPane.simulateDay(model);
    }

    /**
     * A method that allows the user to view the stats of the plant objects after simulating a day
     */
    @FXML
    public void viewPlantStats() {
        simulationPane.plantStats(model);
    }

    /**
     * A method that allows the user to view the stats of the plant eater objects after simulating a day
     */
    @FXML
    public void viewPlantEaterStats() {
        simulationPane.plantEaterStats(model);
    }

    /**
     * A method that allows the user to view the stats of the meat eater objects after simulating a day
     */
    @FXML
    public void viewMeatEaterStats() {
        simulationPane.meatEaterStats(model);
    }

    /**
     * A method that allows the user to view the stats of the human objects after simulating a day
     */
    @FXML
    public void viewHumanStats() {
        simulationPane.humanStats(model);
    }

    /**
     * A method that makes a plant eater object chew a plant object
     */
    @FXML
    public void chew() {
        simulationPane.chew(model);
        try {
            if (model.getPlants().size() == 0) {
                throw new NoPlantException("There are no plants to chew");
            }
        } catch (NoPlantException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A method that makes a meat eater object eat a plant eater object
     */
    @FXML
    public void eat() {
        simulationPane.eat(model);
        try {
            if (model.getPlantEaters().size() == 0) {
                throw new NoPlantEaterException("There are no plant eaters to eat");
            }
        } catch (NoPlantEaterException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * A method that makes a human object hunt
     */
    @FXML
    public void hunt() {
        simulationPane.hunt(model);
        try {
            if (model.getMeatEaters().size() == 0) {
                throw new NoMeatEaterException("There are no meat eaters to eat");
            }
            if (model.getPlantEaters().size() == 0) {
                throw new NoPlantEaterException("There are no plant eaters to eat");
            }
            if (model.getPlants().size() == 0) {
                throw new NoPlantException("There are no plants to chew");
            }
        } catch (NoMeatEaterException e) {
            System.out.println(e.getMessage());
        } catch (NoPlantEaterException e) {
            System.out.println(e.getMessage());
        } catch (NoPlantException e) {
            System.out.println(e.getMessage());
        }

    }
    private class NegativeNumberException extends RuntimeException {
        public NegativeNumberException(String message) {
            super(message);
        }
    }
    private class NoPlantException extends RuntimeException {
        public NoPlantException(String message) {
            super(message);
        }
    }
    private class NoPlantEaterException extends RuntimeException {
        public NoPlantEaterException(String message) {
            super(message);
        }
    }
    private class NoMeatEaterException extends RuntimeException {
        public NoMeatEaterException(String message) {
            super(message);
        }
    }

    

}

