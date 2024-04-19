package edu.guilford;

import java.util.Random;
/**
 * A class that represents a Human object, which is a subclass of the Critter class
 * A Human object can eat plants, plantEaters, and meatEaters, commute, and pollute the air
 * @author A.Fuad
 * @version 4/18/24
 * @see Critter
 */

public class Human extends Critter {

    /**
     * A Random object that will be used to generate random numbers
     */
    private Random rand = new Random();
    /**
     * An array of Plant objects that a Human object can eat
     */
    private Plant plants[];
    /**
     * An array of PlantEater objects that the Human object can chase and eat
     */
    private PlantEater plantEaters[];
    /**
     * An array of MeatEater objects that the Human object can chase and eat
     */
    private MeatEater meatEaters[];

    /**
     * A constructor that initializes a Human object with a size, growth rate, amount of food needed, and arrays of Plant, PlantEater, and MeatEater objects
     * @param size the initial size of the object (in g)
     * @param rate the initial rate of growth of the object (in g/day)
     * @param foodNeed the amount of food the object needs each day (in g)
     * @param plants an array of Plant objects that the human can eat
     * @param plantEaters an array of PlantEater objects that the human can eat
     * @param meatEaters an array of MeatEater objects that the human can eat
     */
    public Human(float size, float rate, float foodNeed, Plant plants[], PlantEater plantEaters[], MeatEater meatEaters[]) {
        super(size, rate, foodNeed);
        this.plants = plants;
        this.plantEaters = plantEaters;
        this.meatEaters = meatEaters;
    }

    /**
     * A method that simulates a day in the life of the Human object; it first calls the eat method, then the simulateDay method of the Critter class, 
     * and finally the simulateDay method of the Creature class
     */
    @Override
    public void simulateDay() {
        commute();
        super.simulateDay();
    }

   /**
    * A method that simulates the Human object eating a plant object
    * @param randPlant the index of the plant object in the plants array that the Human object will eat
    */
    public void eatPlant(int randPlant) {
        for (int i = 0; i < 5; i++) {
            //int plantToBeHarvested = rand.nextInt(plants.length);
            eat(plants[randPlant].getSize());
            plants[randPlant].die();
        }
    }

    /**
     * A method that simulates the Human object eating a plantEater object
     * @param randPlantEater the index of the plantEater object in the plantEaters array that the Human object will eat
     */
    public void eatPlantEater(int randPlantEater) {
        int numPlantEaters = (rand.nextInt(3) + 1);
        for (int i = 0; i < numPlantEaters; i++) {
            if (rand.nextFloat() < 0.5) {
                //int plantEaterToBeEaten = rand.nextInt(plantEaters.length);
                eat(plantEaters[randPlantEater].getSize());
                plantEaters[randPlantEater].die();
            }
        }
    }

    /**
     * A method that simulates the Human object eating a meatEater object
     * @param randMeatEater the index of the meatEater object in the meatEaters array that the Human object will eat
     */
    public void eatMeatEater(int randMeatEater) {
        int numMeatEaters = (rand.nextInt(2) + 1);
        for (int i = 0; i < numMeatEaters; i++) {
            if (rand.nextFloat() < 0.5) {
                //int meatToBeEaten = rand.nextInt(meatEaters.length);
                eat(meatEaters[randMeatEater].getSize());
                meatEaters[randMeatEater].die();
            }
        }
    }

    /**
     * A method that simulates the Human object commuting, which results in 
     * both air and water pollution based on the size of the vehicle
     */
    public void commute() {
        int randNum = rand.nextInt(4);
        if (randNum == 0) {
            polluteAir(0);
        }
        if (randNum == 1) {
            polluteAir(0);
        }
        if (randNum == 2) {
            float vehicleSize = size * 5;
            polluteAir(vehicleSize);
        }
        if (randNum == 3) {
            float vehicleSize = size * 10;
            //human directly is not causing pollution but the bus still is
            polluteAir(vehicleSize/10);
        }
    
    }

    /**
     * A method that simulates the Human object polluting the air
     * @param amount the amount of pollution that the Human object will cause
     * @return the amount of pollution that the Human object caused
     */
    public float polluteAir(float amount) {
        float pollutionAmount = amount*5/100;
        return pollutionAmount;
    } 
    
}
