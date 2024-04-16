package edu.guilford;
/**
 * A class that represents a critter object in the simulation
 @author A. Fuad
 @version 2/19/24
 @see Creature
 @see PlantEater
 */
public abstract class Critter extends Creature {

    //ATTRIBUTES
    /**
     * A positive floating-point number that is the amount of food the object needs each day (in grams)
     */
    private float foodNeed;
    /**
     * A positive floating-point number that is the amount of food eaten so far in the day 
     * It is set to zero when the object is initialized and at the beginning of each new day
     */
    protected float foodEaten;

    /**
     * A boolean that is true if the object can breathe and false if it cannot
     * If the object cannot breathe, it will die 
     */
    protected boolean canBreathe;
    /**
     * A boolean that is true if the object can drink and false if it cannot
     * If the object cannot drink (ie does not have access to clean water)
     * its growth rate will begin decreasing by 1% each day
     */
    protected boolean canDrink;
   


    //GETTERS AND SETTERS
    /**
     * A getter for foodNeed
     * @return the current value of foodNeed (in g)
     */
    public float getFoodNeed() {
        return foodNeed;
    }
    /**
     * A setter for foodNeed
     * @param foodNeed the new value of foodNeed (in g)
     */
    public void setFoodNeed(float foodNeed) {
        this.foodNeed = foodNeed;
    }

    /** 
     * A setter for canBreathe
     */
    public void setCanBreathe(boolean canBreathe) {
        this.canBreathe = canBreathe;
    }

    /**
     * A setter for canDrink
     */
    public void setCanDrink(boolean canDrink) {
        this.canDrink = canDrink;
    }

    //CONSTRUCTOR
    /**
     * A constructor that initializes a default of the Critter object with a size, growth rate, and amount of food needed; foodEaten will be set to zero
     * @param size the initial size of the object (in g)
     * @param rate  the initial rate of growth of the object (in g/day)
     * @param foodNeed the amount of food the object needs each day (in g)
     * @param canBreathe a boolean that is true if the object can breathe and false if it cannot
     * @param canDrink a boolean that is true if the object can drink and false if it cannot
     */
    public Critter(float size, float rate, float foodNeed, boolean canBreathe, boolean canDrink) {
        super(size, rate);
        this.foodNeed = foodEaten = (15*size)/100; //needs to eat 15% of its size to survive
        canBreathe = true;
        canDrink = true;
    }

    //METHODS
    /**
     * A method that simulates a day in the life of the Critter;
     * The Critter dies if the amount of foodNeed is less than the amount of foodEaten; 
     * If the Critter is still alive, then the amount of foodEaten should be set to zero for the next simulated day
     */
    @Override
    public void simulateDay() {
        super.simulateDay();
        if (foodNeed > foodEaten || !canBreathe) {
            die();
        } else {
            foodEaten = 0;
        }
    }
    /**
     * A method that adds an amount (in g) to the value of foodEaten
     * @param amount the amount of new food eaten (in g)
     */
    public void eat(float amount) {
        foodEaten += amount;
    }

    /**
     * Returns the amount of food still needed (foodNeed - foodEaten)
     * @return the amount of food still needed (in g)
     */
    public float stillNeed() {
        if (foodNeed - foodEaten > 0) {
            return foodNeed - foodEaten;
        }
        else {
            return 0;
        }
        
    }

}


