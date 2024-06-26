package edu.guilford;

import java.util.Random;
/**
 * A class that represents a meat eater object in the simulation
 * @author A. Fuad
 * @version 2/29/24
 * @see Critter
 * @see PlantEater
 */
public class MeatEater extends Critter {

    //ATTRIBUTES
    /**
     * An array of PlantEater objects that the meat eater object can chase and eat
     */
    private PlantEater[] plantEaters;
    private Random rand = new Random();

    //CONSTRUCTOR
    /**
     * A constructor that initializes a meat eater object with a size, growth rate, and amount of food needed; foodEaten will be set to zero
     * @param size the initial size of the object (in g)
     * @param rate  the initial rate of growth of the object (in g/day)
     * @param foodNeed the amount of food the object needs each day (in g)
     * @param plantEaters the array of plant eater objects that the meat eater object can chase and eat
     */
    public MeatEater(float size, float rate, float foodNeed, PlantEater[] plantEaters) {
        super(size, rate, foodNeed);
        this.plantEaters = plantEaters;
        
    }

    //METHODS
    /**
     * A method that simulates a day in the life of the meat eater object; it first calls the eat method, 
     * then the simulateDay method of the Critter class, and finally the simulateDay method of the Creature class
     */
    @Override
    public void simulateDay() {
        super.simulateDay();
    }

    /**
     * A method that simulates the meat eater object eating; it chases a random number of plant eater objects and eats them
     */
    public void eat() {
        //a meat eater object can chase one or two plant eater objects a day
        //  int numChases = (rand.nextInt() * 2 + 1);
        int numChases = (rand.nextInt(2) + 1);
         for (int i = 0; i < numChases; i++) {
             //it has a specified probability of catching the plant eater object
             if (rand.nextFloat() < 0.5) {
                 //if it does so, the meat eater will use its eat method with the current mass of the plant eater object
                 int plantToBeEaten = rand.nextInt(plantEaters.length);
                 eat(plantEaters[plantToBeEaten].getSize());
                 //the plant eater object will then invoke its die method
                 plantEaters[plantToBeEaten].die();
             }
         } 
    }

    /**
     * A method that sets the plant eater array of the meat eater object
     * @param plantEaters the array of plant eater objects that the meat eater object can chase and eat
     */
    public void setPlantEaters(PlantEater[] plantEaters) {
        this.plantEaters = plantEaters;
    }

    /**
     * A setter that sets the size of the meat eater object
     * @param size the new size of the meat eater object (in g)
     */
    public void setSize(float size) {
        this.size = size;    
    }





}

