package edu.guilford;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is the model for the simulation. It contains starting meat eater, plant, and plant eater objects. The user can add more of these objects to the simulation.
 * @Author A. Fuad
 * @Version 4/7/24
 * @See SimulationPane
 * @See ControlController
 */

public class SimulationModel {

    /**
     * A random object that is used to generate random numbers
     */
    Random rand = new Random();


    /**
     * A list of plant objects that are the first plants in the simulation
     */
    private List<Plant> plants = new ArrayList<Plant>();


    /**
     * A list of plant eater objects that are in the simulation
     */
    private List<PlantEater> plantEaters = new ArrayList<PlantEater>();
    

    /**
     * A list of meat eater objects that are in the simulation
     */
    private List<MeatEater> meatEaters = new ArrayList<MeatEater>();


    /** 
     * A constructor that sets up the simulation model.
     * @param numPlants the number of plant objects in the simulation
     * @param numMeatEaters the number of meat eater objects in the simulation
     * @param numPlantEaters the number of plant eater objects in the simulation
     * @param plantSize the initial size of the plant objects (in g)
     * @param plantRate the initial rate of growth of the plant objects (in g/day)
     * @param meatEaterSize the initial size of the meat eater objects (in g)
     * @param meatEaterRate the initial rate of growth of the meat eater objects (in g/day)
     * @param plantEaterSize the initial size of the plant eater objects (in g)
     * @param plantEaterRate the initial rate of growth of the plant eater objects (in g/day)
     * */ 
    // public SimulationModel(int numPlants, int numMeatEaters, int numPlantEaters, float plantSize, float plantRate, float meatEaterSize, float meatEaterRate, float plantEaterSize, float plantEaterRate) {
    //     for (int i = 0; i < numPlants; i++) {
    //         plants.add(new Plant(plantSize, plantRate));
    //     }
    //     for (int i = 0; i < numMeatEaters; i++) {
    //         meatEaters.add(new MeatEater(meatEaterSize, meatEaterRate, (15*meatEaterSize)/100));
    //     }
    //     for (int i = 0; i < numPlantEaters; i++) {
    //         plantEaters.add(new PlantEater(plantEaterSize, plantEaterRate, (15*plantEaterSize)/100, plants.toArray(new Plant[plants.size()])));
    //     }
    // }
    
    /**
     * A constructor that sets up the simulation model.
     */
    public SimulationModel() {
        
    }

    /**
     * A method that simulates a day in the simulation; it first simulates a day for each plant object, then for each plant eater object, and finally for each meat eater object
     */
    public void simulateDay() {
        for (Plant p : plants) {
            p.simulateDay();
        }
        for (PlantEater pe : plantEaters) {
            pe.simulateDay();
        }
        // for (MeatEater me : meatEaters) {
        //     me.simulateDay();
        // }
        
    }

    /**
     * A method that adds a new plant object to the simulation
     * @param size the size of the new plant object (in g)
     * @param rate the rate of growth of the new plant object (in g/day)
     */
    public void addPlant(float size, float rate) {
        plants.add(new Plant(size, rate));
    }

     /**
     * A method that adds a new plant eater object to the simulation
     * @param size the size of the new plant eater object (in g)
     * @param rate the rate of growth of the new plant eater object (in g/day)
     */
    public void addPlantEater(float size, float rate) {
        plantEaters.add(new PlantEater(size, rate, (15*size)/100, plants.toArray(new Plant[plants.size()])));
    }

     /**
     * A method that adds a new meat eater object to the simulation
     * @param size the size of the new meat eater object (in g)
     * @param rate the rate of growth of the new meat eater object (in g/day)
     */
    public void addMeatEater(float size, float rate, PlantEater[] plantEaters) {
        meatEaters.add(new MeatEater(size, rate, (15*size)/100, plantEaters));
    }

    /**
     * A method that enables a plant eater to chew on a random plant object
     */
    public void chew(PlantEater pe, Plant p) {
        //PlantEater pe = plantEaters.get(rand.nextInt(plantEaters.size()));
        //Plant p = plants.get(rand.nextInt(plants.size()));
        pe.chew(p); 
    }


    /**
     * A method that returns the list of plant objects in the simulation
     * @return the list of plant objects in the simulation
     */
    public List<Plant> getPlants() {
        return plants; 
    }

    /**
     * A method that returns the list of plant eater objects in the simulation
     * @return the list of plant eater objects in the simulation
     */
    public List<PlantEater> getPlantEaters() {
        return plantEaters; 
    }

    /**
     * A method that returns the list of meat eater objects in the simulation
     * @return the list of meat eater objects in the simulation
     */
    public List<MeatEater> getMeatEaters() {
        return meatEaters; 
    }

    

   

}

   
