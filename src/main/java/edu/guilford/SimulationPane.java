package edu.guilford;

import java.util.Random;

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
     * A random number generator
     */
    Random rand = new Random();

    /**
     * A reference to the simulation model that is displayed by this pane
     */
    SimulationModel model;

    /**
     * The row in the grid pane where the next object will be added
     */
    private int row = 0;

    /**
     * An array of PlantEater objects that the meat eater object can chase and eat
     */
    private PlantEater[] plantEaters;

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
        plantEaters = model.getPlantEaters().toArray(new PlantEater[model.getPlantEaters().size()]);
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
        model.addMeatEater(size, rate, plantEaters);
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

    /**
     * A method that displays the total plant population size, average size, and average growth rate
     * @param model the simulation model that contains the plant objects
     */
    public void plantStats(SimulationModel model) {
        int plantPop = model.getPlants().size();
        float plantGrowthRate = 0;
        float plantSize = 0;

        for (int i = 0; i < model.getPlants().size(); i++) {
            plantGrowthRate += model.getPlants().get(i).getRate();
            plantSize += model.getPlants().get(i).getSize();
        }

        plantGrowthRate /= plantPop;
        plantSize /= plantPop;

        plantGrowthRate = Math.round(plantGrowthRate * 100.0f) / 100.0f;
        plantSize = Math.round(plantSize * 100.0f) / 100.0f;

        Label testLabel = new Label("Total plant population size: " + plantPop + " plants. Average plant size: " + plantSize + "g. Average growth rate: " + plantGrowthRate + " g/day");
        this.add(testLabel, 0, row);
        row++;
    }

    /**
     * A method that displays the total plant eater population size, average size, average growth rate, and average food need
     * @param model the simulation model that contains the plant eater objects
     */
    public void plantEaterStats(SimulationModel model) {
        int plantEaterPop = model.getPlantEaters().size();
        float plantEaterGrowthRate = 0;
        float foodNeed = 0;
        float plantEaterSize = 0;

        for (int i = 0; i < model.getPlants().size(); i++) {
            plantEaterGrowthRate += model.getPlantEaters().get(i).getRate();
            plantEaterSize += model.getPlantEaters().get(i).getSize();
            foodNeed += model.getPlantEaters().get(i).getFoodNeed();
        }

        plantEaterSize /= plantEaterPop;
        plantEaterGrowthRate /= plantEaterPop;
        foodNeed /= plantEaterPop;

        plantEaterSize = Math.round(plantEaterSize * 100.0f) / 100.0f;
        plantEaterGrowthRate = Math.round(plantEaterGrowthRate * 100.0f) / 100.0f;
        foodNeed = Math.round(foodNeed * 100.0f) / 100.0f;

        Label testLabel = new Label("Total plant eater population size: " + plantEaterPop + " plant eaters. Average plant eater size: " + plantEaterSize + "g. Average growth rate: " + plantEaterGrowthRate + " g/day" + " Average food need: " + foodNeed + " g/day");
        this.add(testLabel, 0, row);
        row++;
    }

    /**
     * A method that displays the total meat eater population size, average size average growth rate, and average food need
     * @param model the simulation model that contains the meat eater objects
     */
    public void meatEaterStats(SimulationModel model) {
        int meatEaterPop = model.getMeatEaters().size();
        float meatEaterGrowthRate = 0;
        float foodNeed = 0;
        float meatEaterSize = 0;

        for (int i = 0; i < model.getMeatEaters().size(); i++) {
            meatEaterGrowthRate += model.getMeatEaters().get(i).getRate();
            foodNeed += model.getMeatEaters().get(i).getFoodNeed();
            meatEaterSize += model.getMeatEaters().get(i).getSize();
        }

        meatEaterSize /= meatEaterPop;
        meatEaterGrowthRate /= meatEaterPop;
        foodNeed /= meatEaterPop;

        meatEaterSize = Math.round(meatEaterSize * 100.0f) / 100.0f;
        meatEaterGrowthRate = Math.round(meatEaterGrowthRate * 100.0f) / 100.0f;
        foodNeed = Math.round(foodNeed * 100.0f) / 100.0f;

        Label testLabel = new Label("Total meat eater population size: " + meatEaterPop + " meat eaters. Average meat eater size: " + meatEaterSize + "g. Average growth rate: "  + meatEaterGrowthRate + " g/day" + " Average food need: " + foodNeed + " g/day");
        this.add(testLabel, 0, row);
        row++;
    }

    /**
     * A method that displays the plant eater object chewing on a plant object
     * @param model the simulation model that contains the plant eater and plant objects
     */
    public void chew(SimulationModel model) {
        Plant randPlant = model.getPlants().get(rand.nextInt(model.getPlants().size()));
        plantEaters[plantEaters.length - 1].chew(randPlant);
        Label testLabel = new Label("Plant eater chewed on a plant");
        model.getPlants().remove(randPlant);
        this.add(testLabel, 0, row);
        row++;
    }  
}
