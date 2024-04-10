package edu.guilford;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * A class that generates the simulation pane that displays the simulation.
 * @Author A. Fuad
 * @Version 4/7/24
 * @See SimulationModel
 * @See ControlController
 */

public class SimulationPane extends GridPane {

    /**
     * A reference to the simulation model that is displayed by this pane
     */
    SimulationModel model;

    /**
     * A constructor that sets up the simulation pane
     */
    public SimulationPane() {
        super();
    }

   /**
    * A method that adds a plant object to the simulation
    * @param size the size of the plant object
    * @param rate the rate of growth of the plant object
    * @param model the simulation model that contains the plant object
    */
    public void addPlant(float size, float rate, SimulationModel model) {
        model.addPlant(size, rate);
        Label testLabel = new Label("Plant added with size: " + size + " g and rate: " + rate + " g/day");
        this.add(testLabel, 0, 0);
        
    }

    /**
     * A method that adds a plant eater object to the simulation
     * @param size the size of the plant eater object
     * @param rate the rate of growth of the plant eater object
     * @param model the simulation model that contains the plant eater object
     */
    public void addPlantEater(float size, float rate, SimulationModel model) {
        model.addPlantEater(size, rate);
        Label testLabel = new Label("Plant eater added with size: " + size + " g and rate: " + rate + " g/day");
        this.add(testLabel, 0, 1);
        
    }

    /**
     * A method that adds a meat eater object to the simulation
     * @param size the size of the meat eater object
     * @param rate the rate of growth of the meat eater object
     * @param model the simulation model that contains the meat eater object
     */
    public void addMeatEater(float size, float rate, SimulationModel model) {
        model.addMeatEater(size, rate);
        Label testLabel = new Label("Meat eater added with size: " + size + " g and rate: " + rate + " g/day");
        this.add(testLabel, 0, 4);
        
    }

    

}
