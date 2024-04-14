package edu.guilford;

import java.util.Random;

/**
 * A class that represents a plant eater (herbivore) in the simulation
 @author A. Fuad
 @version 2/19/24
 @see Critter
 @see Plant
 */
public class PlantEater extends Critter {

    //ATTRIBUTES
    /**
     * An array of Plant objects that a PlantEater object can eat
     */
    private Plant[] plants;
    private Random rand = new Random();

    //CONSTRUCTOR
    /**
     * A constructor that initializes a default PlantEater object with a size, growth rate, amount of food needed, and a list of Plant objects it can eat
     * @param size the initial size of the object (in g)
     * @param rate the initial rate of growth of the object (in g/day)
     * @param foodNeed the amount of food the object needs each day (in g)
     * @param plants  an array of Plant objects that the object can eat
     */
    public PlantEater(float size, float rate, float foodNeed, Plant[] plants) {
        super(size, rate, foodNeed);
        this.plants = plants;
    }


    //METHODS
    /**
     * The PlantEater object eats (chews) part of a specified Plant object. The amount it chews is random, but cannot exceed half of the size of the Plant
     * @param plant the Plant object to be chewed on
     */
    public void chew(Plant plant) {
        float amount = plant.getSize();
        plant.chewedOn(amount);
        eat(amount);
        size += amount;
    }

   
    public void eaten() {
        die();
    }

    /**
     * A method that simulates a day in the life of the PlantEater; it first chews on a randomly determined number of plants; 
     * after chewing on all the plants, it calls the simulateDay method of the Critter class and then the simulateDay method of the Creature class
     * and makes changes to the object's size and age accordingly
     */
    @Override
    public void simulateDay() {
        int numPlants = (int) (plants.length * (rand.nextFloat() * 0.02 + 0.005));
        for (int i = 0; i < numPlants; i++) {
            chew(plants[rand.nextInt(plants.length)]);
        }
        super.simulateDay();
    }

    /**
     * A method that returns a string representation of the object
     * @return a string representation of the object containing size (g), growth rate (g/day), amount of food needed (g), and the number of plants available to the object
     */
    @Override
    public String toString() {
        return "PlantEater: size = " + getSize() + "g, rate = " + getRate() + "g/day, foodNeed = " + getFoodNeed() + "g/day, plants = " + plants.length;
    }

    /**
     * A method that returns the amount of food eaten by the PlantEater object
     * @return the amount of food eaten by the PlantEater object (in g)
     */
    public float getFoodEaten() {
        return foodEaten;
    }


    public void setSize(float size) {
        this.size = size;
    }

}

