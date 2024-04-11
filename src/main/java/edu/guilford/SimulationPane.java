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
     * The row in the grid pane where the next object will be added
     */
    private int row = 0;

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
        Label testLabel = new Label("Plant added. Plant population is now: " + model.getPlants().size() + " plants");
        this.add(testLabel, 0, row);
        row++;
        
    }

    /**
     * A method that adds a plant eater object to the simulation
     * @param size the size of the plant eater object
     * @param rate the rate of growth of the plant eater object
     * @param model the simulation model that contains the plant eater object
     */
    public void addPlantEater(float size, float rate, SimulationModel model) {
        model.addPlantEater(size, rate);
        Label testLabel = new Label("Plant eater added. Plant eater population is now: " + model.getPlantEaters().size() + " plant eaters");
        this.add(testLabel, 0, row);
        row++;
        
    }

    /**
     * A method that adds a meat eater object to the simulation
     * @param size the size of the meat eater object
     * @param rate the rate of growth of the meat eater object
     * @param model the simulation model that contains the meat eater object
     */
    public void addMeatEater(float size, float rate, SimulationModel model) {
        model.addMeatEater(size, rate);
        Label testLabel = new Label("Meat eater added. Meat eater population is now: " + model.getMeatEaters().size() + " meat eaters");
        this.add(testLabel, 0, row);
        row++;
        
    }

    /**
     * A simulate day method that simulates a day in the simulation
     * @param model the simulation model that is being simulated
     */
    public void simulateDay(SimulationModel model) {
        model.simulateDay();
        Label testLabel = new Label("One day has been simulated.");
        this.add(testLabel, 0, row);
        row++;
    }

    

}
