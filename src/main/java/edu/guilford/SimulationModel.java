package edu.guilford;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is the model for the simulation. It contains starting meat eater, plant, and plant eater objects. The user can add more of these objects to the simulation.
 * @author A. Fuad
 * @version 4/7/24
 * @see SimulationPane
 * @see ControlController
 * @see InstructionPane
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
     * A list of human objects that are in the simulation
     */
    private List<Human> humans = new ArrayList<Human>();

    
    /**
     * A constructor that sets up the simulation model.
     */
    public SimulationModel() {
        
    }

    /**
     * A method that simulates a day in the simulation for each type of object
     */
    public void simulateDay() {
        for (Plant p : plants) {
            p.simulateDay();
        }
        for (PlantEater pe : plantEaters) {
            pe.simulateDay();
        }
        for (MeatEater me : meatEaters) {
            me.simulateDay();
        }
        // for (Human h : humans) {
        //     h.simulateDay();
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
    public void addMeatEater(float size, float rate, PlantEater[] plantArray) {
        meatEaters.add(new MeatEater(size, rate, (15*size)/100, plantArray));
    }

    /**
     * A method that adds a new human object to the simulation
     * @param size the size of the new human object (in g)
     * @param rate the rate of growth of the new human object (in g/day)
     */
    public void addHuman(float size, float rate) {
        humans.add(new Human(size, rate, (15*size)/100, plants.toArray(new Plant[plants.size()]), plantEaters.toArray(new PlantEater[plantEaters.size()]), meatEaters.toArray(new MeatEater[meatEaters.size()])));
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

    /**
     * A method that returns the list of human objects in the simulation
     * @return the list of human objects in the simulation
     */
    public List<Human> getHumans() {
        return humans;
    }

    /**
     * A method that sets the list of plant objects in the simulation
     * @param plants the list of plant objects in the simulation
     */
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
    
    /**
     * A method that sets the list of plant eater objects in the simulation
     * @param plantEaters the list of plant eater objects in the simulation
     */
    public void setPlantEaters(List<PlantEater> plantEaters) {
        this.plantEaters = plantEaters;
    }

    /**
     * A method that sets the list of meat eater objects in the simulation
     * @param meatEaters the list of meat eater objects in the simulation
     */
    public void setMeatEaters(List<MeatEater> meatEaters) {
        this.meatEaters = meatEaters;
    }

    /**
     * A method that sets the list of human objects in the simulation
     * @param humans the list of human objects in the simulation
     */
    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    /**
     * A method that clears the simulation of all objects
     */
    public void restart() {
        plants.clear();
        plantEaters.clear();
        meatEaters.clear();
        humans.clear();
    }

    

   

}

   
