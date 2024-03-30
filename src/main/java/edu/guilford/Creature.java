package edu.guilford;

/**
 * A class that represents a creature in the simulation
 @author A. Fuad
 @version 2/19/24
 @see Critter
 @see Plant
 */

public abstract class Creature {

    //ATTRIBUTES
    /**A positive floating-point number that is the current size of the object (in grams)*/
    protected float size;
    /**A floating-point number that is the current rate of growth of the object (in grams/day)*/
    protected float rate;
    /** A boolean with true meaning alive and false meaning dead; is initialized to true when the object is instantiated*/
    protected boolean alive;
    /**An integer that is the number of days the object has been alive; it is alway initialized to zero*/
    protected int age;

    //GETTERS AND SETTERS
    /**A getter for size
     * @return the current value of size (in g)
    */
    public float getSize() {
        return size;
    }
    /**
     * A getter for rate
     * @return the current value of rate (in g/day)
     */
    public float getRate() {
        return rate;
    }
    /**
     * A getter for the value of alive
     * @return the current value of alive (true or false)
     */
    public boolean isAlive() {
        return alive;
    }
    
    /**
     * A getter for age
     * @return the current value of age (in days)
     */
    public int getAge() {
        return age;
    }
    /**
     * A setter for rate
     * @param rate the new value of size (in g)
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    //CONSTRUCTOR
    /**
     * A constructor that initializes the size and rate of the object to the specified values and sets alive to true and age to zero
     * @param size the initial size of the object (in g)
     * @param rate the initial rate of growth of the object (in g/day)
     */
    public Creature(float size, float rate) {
        this.size = size;
        this.rate = rate;
        alive = true;
        age = 0;
    }

    //METHODS
    /**
     * Changes the value of size by a specified amount; if size is less than or equal to zero, then the object invokes die() and alive is set to False
     * @param amount the amount by which to change the size (in g)
     */
    public void changeSize(float amount) {
        size += amount;
        if (size <= 0) {
            die();
        }
    }
    /** 
     * Simulates one day of growth for the object by changing the size and increasing the age by one
    */
    public void simulateDay() {
        changeSize(rate);
        age++;
    }
    /**
     * Makes an object "dead" by setting size and rate to 0 and setting alive to False.*/
    public void die() {
        size = 0;
        rate = 0;
        alive = false;
    }

}
