/*
 * Stewart Lovell
 * Toy.java
 * 5/16/2022
 */

/**
 * Toy class, implements Comparable, Constructs a toy object and includes methods to interact with it
 */
public class Toy implements Comparable<Toy> {

    private String name;
    private double price;

    /**
     * Default constructor for the Toy class
     */
    public Toy(){}

    /**
     * Parameterized constructor for the Toy class, constructs a Toy object
     * @param name The name of the toy
     * @param price The price of the toy
     */
    public Toy(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the price of the toy and returns it
     * @return The price of the toy
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Method that will set the toy's price to the given value
     * @param price Price that the toy will be changed to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the toy's name and returns it
     * @return Name of the toy
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compares two toy names to each other alphabetically
     * @param other The other Toy object that will be compared to this Toy object
     * @return Returns >0 if this comes before other, <0 if other comes before this, and 0 if they are they same
     */
    @Override
    public int compareTo(Toy other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    /**
     * Method that returns a String representation of the Toy object
     * @return String representation of the Toy object
     */
    @Override
    public String toString() {
        return "Toy: " + this.name + " Price: " + this.price;
    }
}