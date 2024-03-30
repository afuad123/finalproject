package edu.guilford;
/**
 * A class that represents a plant in the simulation
 @author A. Fuad
 @version 2/19/24
 @see Creature
 @see PlantEater
 */
public class Plant extends Creature {

    //CONSTRUCTOR
    /**
     * A constructor that initializes a default of the Plant object with a size and growth rate
     * @param size the initial size of the object (in g)
     * @param rate the initial rate of growth of the object (in g/day)
     */
    public Plant(float size, float rate) {
        super(size, rate);
    }

    //METHODS
    /**
     * The size of this object is decreased by a specified amount after being chewed on; the amount cannot exceed the current size of the object
     * @param amount the amount by which to decrease the size (in g)
     */
    public void chewedOn(float amount) {
        //if the amount is greater than the size, then the size is set to zero (entire plant object has been eaten)
        if (amount > size) {
            size = 0;
            die();
        } else {
            size -= amount;
        }
    }
    
    /**
     * A method that returns a string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Plant: size = " + size + "g, rate = " + rate + "g/day, alive = " + alive + ", age = " + age + " days";
    }

}

