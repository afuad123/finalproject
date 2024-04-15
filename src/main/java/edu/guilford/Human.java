package edu.guilford;

import java.util.Random;

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
        eat();
        super.simulateDay();
    }

    /**
     * A method that simulates the Human object eating; it chases/harvests a random number of food objects and eats them
     */
    public void eat() {
        //a human can chase 1-3 plantEaters a day and 1-2 meatEaters a day, with a 50% chance of catching each
        int numPlants = (rand.nextInt() * 3 + 1);
        int numMeat = (rand.nextInt() * 2 + 1);
        for (int i = 0; i < numPlants; i++) {
            if (rand.nextFloat() < 0.5) {
            int plantToBeEaten = rand.nextInt(plants.length);
            eat(plants[plantToBeEaten].getSize());
            plants[plantToBeEaten].die();
            }
        }
        for (int i = 0; i < numMeat; i++) {
            if (rand.nextFloat() < 0.5) {
                int meatToBeEaten = rand.nextInt(meatEaters.length);
                eat(meatEaters[meatToBeEaten].getSize());
                meatEaters[meatToBeEaten].die();
            }
        }
        //a human can also harvest 5 plants a day
        for (int i = 0; i < 5; i++) {
            int plantToBeHarvested = rand.nextInt(plants.length);
            eat(plants[plantToBeHarvested].getSize());
            plants[plantToBeHarvested].die();
        }
    }

    
    
    
}
