package edu.guilford;

import java.util.Random;
/**
 * A class that represents a Human object, which is a subclass of the Critter class
 * A Human object can eat plants, plantEaters, and meatEaters, commute, and pollute the air and water
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
     * A method that simulates the Human object eating; it chases/harvests a random number of food objects and eats them
     * A human can chase 1-3 plantEaters a day and 1-2 meatEaters a day, with a 50% chance of catching each
     * A human can also harvest 5 plants a day
     */

    public void eatPlant(int randPlant) {
        for (int i = 0; i < 5; i++) {
            //int plantToBeHarvested = rand.nextInt(plants.length);
            eat(plants[randPlant].getSize());
            plants[randPlant].die();
        }
    }

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

    public float polluteAir(float amount) {
        float pollutionAmount = amount*5/100;
        return pollutionAmount;
    } 
    
}
