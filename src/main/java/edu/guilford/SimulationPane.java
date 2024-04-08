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

    public SimulationPane() {
        super();
    }

    /**
     * A method that adds a new creature to the simulation
     */
    public void addCreature() {
        

    }

    public void addPlant(float size, float rate, SimulationModel model) {
        model.addPlant(size, rate);
        Label testLabel = new Label("Plant added");
        this.add(testLabel, 0, 0);
        
    }

    public void addPlantEater(float size, float rate, SimulationModel model) {
        model.addPlantEater(size, rate);
        
    }

    public void addMeatEater(float size, float rate, SimulationModel model) {
        model.addMeatEater(size, rate);
        
    }

    

}
