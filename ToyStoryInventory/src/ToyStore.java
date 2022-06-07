/*
 * Stewart Lovell
 * ToyStore.java
 * 5/16/2022
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * ToyStore class, constructs a ToyStore object and includes methods to interact with it
 */
public class ToyStore {

    Map<Toy, Integer> toyMap;

    /**
     * Default constructor for the ToyStore class - constructs a TreeMap
     */
    public ToyStore(){
        toyMap = new TreeMap<>();
    }


    /**
     * Method that takes in a string, splits the string into smaller parts,
     * creates and puts a toy object into the map, or increments that toy's
     * count if it already exists
     * @param toys String that contains toy names and their prices
     */
    public void loadToys(String toys) {
        // split the string of toys on a blank space
        String[] splitToys = toys.split(" ");

        // for every string like "Barbie-9.99" in your split strings
        for (String s : splitToys) {
            // split again on the dash "-"
            String[] splitToysAgain = s.split("-");
            // isolate the toyName as a String
            String toyName = splitToysAgain[0];
            // isolate the price as a Double (Double.parseDouble())
            double toyPrice = Double.parseDouble(splitToysAgain[1]);
            // call findToy with the toyName and CAPTURE the returned Toy object
            Toy toy = findToy(toyName);

            // if the returned Toy object is not null
            if (toy != null) {
                // get the toyCount for the Toy Object
                int toyCount = toyMap.get(toy);
                // increment the toyCount and
                toyCount++;
                // place the Toy back in the Map
                toyMap.put(toy, toyCount);
            } else {  // else the Toy object is not in the Map
                // create a new Toy with the toyName and toyPrice and place it in the map
                Toy newToy = new Toy(toyName, toyPrice);
                toyMap.put(newToy, 1);
            }
        }
    }

    /**
     * Method that searches through the map for a Toy object with the specified name
     * @param toyName Name of the toy to search for
     * @return Toy object if a match is found, null otherwise
     */
    public Toy findToy (String toyName) {
        // Loop through the map, comparing toyName to each key in the map
        for (Map.Entry<Toy, Integer> m : toyMap.entrySet()) {
            // If we find a match
            if (toyName.equalsIgnoreCase(m.getKey().getName())) {
                // return the Toy object that matches
                return m.getKey();
            }
        }
        // Otherwise, return null
        return null;
    }


    /**
     * Method that searches the map for the most purchased toy
     * @return Name of the most purchased toy
     */
    public String getMostFrequentToy() {
        // Create a string to hold the name of the toy
        String mostFrequent = "";
        // Create a count to compare to the values in the map
        int count = 0;
        // For each loop to iterate through the map
        for (Map.Entry<Toy, Integer> m : toyMap.entrySet()) {
            // if count is less than the current map value
            if (count < m.getValue()) {
                // set count equal to that value
                count = m.getValue();
                // set mostFrequent equal to the current Toy object's (key) name
                mostFrequent = m.getKey().getName();
            }
        }
        // return the name of the most frequently purchased toy
        return mostFrequent;
    }


    /**
     * Method that returns a String representation of the map
     * @return String representation of the map
     */
    @Override
    public String toString() {
        return toyMap.toString();
    }
}
