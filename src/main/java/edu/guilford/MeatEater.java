package edu.guilford;

import java.util.Random;
/**
 * A class that represents a meat eater object in the simulation
 * @Author A. Fuad
 * @Version 2/29/24
 * @See Critter
 * @See PlantEater
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
     */
    public MeatEater(float size, float rate, float foodNeed, PlantEater[] plantEaters) {
        super(size, rate, foodNeed);
        this.plantEaters = plantEaters;
        
    }

    /* 
    
    @Override
    public void simulateDay() {
        int numPlants = (int) (plants.length * (rand.nextFloat() * 0.02 + 0.005));
        for (int i = 0; i < numPlants; i++) {
            chew(plants[rand.nextInt(plants.length)]);
        }
        super.simulateDay();
    }*/

    //METHODS
    /**
     * A method that simulates a day in the life of the meat eater; along with adding onto the simulateDay method in the Critter class,
     * the meat eater object can chase and eat one or two plant eater objects a day, causing the plant eater to die.
     */
    @Override
    public void simulateDay() {
        //a meat eater object can chase one or two plant eater objects a day
        int numChases = (rand.nextInt() * 2 + 1);
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
       // eat();
        super.simulateDay();
    }

    /*public void chew(Plant plant) {
        float amount = (rand.nextFloat() * plant.getSize()) / 2;
        plant.chewedOn(amount);
        eat(amount);
        size += amount;
    } */
    public void eat() {
        //  //a meat eater object can chase one or two plant eater objects a day
        //  int numChases = (rand.nextInt() * 2 + 1);
        //  for (int i = 0; i < numChases; i++) {
        //      //it has a specified probability of catching the plant eater object
        //      if (rand.nextFloat() < 0.5) {
        //          //if it does so, the meat eater will use its eat method with the current mass of the plant eater object
        //          int plantToBeEaten = rand.nextInt(plantEaters.length);
        //          eat(plantEaters[plantToBeEaten].getSize());
        //          //the plant eater object will then invoke its die method
        //          plantEaters[plantToBeEaten].die();
        //      }
        //  } 
        int numChases = (rand.nextInt() * 2 + 1);
        for (int i = 0; i < numChases; i++) {
            if (rand.nextFloat() < 0.5) {

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





}

