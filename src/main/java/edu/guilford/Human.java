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
        super(size, rate, foodNeed, true, true);
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
       //commute(null);
        super.simulateDay();
    }

    /**
     * A method that simulates the Human object eating; it chases/harvests a random number of food objects and eats them
     * A human can chase 1-3 plantEaters a day and 1-2 meatEaters a day, with a 50% chance of catching each
     * A human can also harvest 5 plants a day
     */
    public void eat() {
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
        for (int i = 0; i < 5; i++) {
            int plantToBeHarvested = rand.nextInt(plants.length);
            eat(plants[plantToBeHarvested].getSize());
            plants[plantToBeHarvested].die();
        }
        polluteAir(size);
    }

    /**
     * A method that simulates the Human object commuting, which results in 
     * both air and water pollution based on the size of the vehicle
     */
    public void commute(String vehicle) {
        if (vehicle == "walk") {
            polluteAir(0);
            polluteWater(0);
        }
        if (vehicle == "bike") {
            polluteAir(0);
            polluteWater(0);
        }
        if (vehicle == "car") {
            float vehicleSize = size * 5;
            polluteAir(vehicleSize);
            polluteWater(vehicleSize/5);
        }
        if (vehicle == "bus") {
            float vehicleSize = size * 10;
            //human directly is not causing pollution but the bus still is
            polluteAir(vehicleSize/10);
            polluteWater(vehicleSize/10);
        }
    
    }

    //a method that makes the human pollute the air
    public void polluteAir() {
        //if the human pollutes the air by more than 90% of the air, the everything can't breathe
        if (polluteAir(size) > 0.9) {
            for (int i = 0; i < plantEaters.length; i++) {
                plantEaters[i].setCanBreathe(false);
            }
            for (int i = 0; i < meatEaters.length; i++) {
                meatEaters[i].setCanBreathe(false);
            }
        }

    }

    public float polluteAir(float amount) {
        float pollutionAmount = amount*5/100;
        return pollutionAmount;
    }

    //a method that makes the human pollute the water
    public void polluteWater() {
        //if the human pollutes the water by more than 50% of its size, the everything can't drink
        if (polluteWater(size) > 0.9) {
            for (int i = 0; i < plantEaters.length; i++) {
                plantEaters[i].setCanDrink(false);
            }
            for (int i = 0; i < meatEaters.length; i++) {
                meatEaters[i].setCanDrink(false);
            }
        }
    }

    public float polluteWater(float amount) {
        float pollutionAmount = amount*5/100;
        return pollutionAmount;
    }

    
    
    
}
