package cp213;

import java.io.PrintStream;

/**
 * Food class definition.
 *
 * @author your name, id, email here
 * @version 2023-05-07
 */
public class Food implements Comparable<Food> {

    // Constants
    public static final String ORIGINS[] = { "Canadian", "Chinese", "Indian", "Ethiopian", "Mexican", "Greek",
	    "Japanese", "Italian", "Moroccan", "Scottish", "Columbian", "English" };

    /**
     * Creates a string of food origins in the format:
     *
     * <pre>
    Origins
    0 Canadian
    1 Chinese
    ...
    11 English
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String originsMenu() {
    	String origin = "Origins";

    	for (int i = 0; i < ORIGINS.length; i++) {
    		origin = origin + "\n" + i + " " + ORIGINS[i];
    	}//for loop

    	return origin;
    }

    // Attributes
    private String name = null;
    private int origin = 0;
    private boolean isVegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name         food name
     * @param origin       food origin code
     * @param isVegetarian whether food is vegetarian
     * @param calories     caloric content of food
     */
    public Food(final String name, final int origin, final boolean isVegetarian, final int calories) {
    	this.name = name;
    	this.origin = origin;
    	this.isVegetarian = isVegetarian;
    	this.calories = calories;

    	return;
    }

    /*
     * (non-Javadoc) Compares this food against another food.
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Foods are compared by name, then by origin if the names match. Must ignore
     * case.
     */
    @Override
    public int compareTo(final Food target) {
    	int x = 0;
    	
    	if (this.name.compareToIgnoreCase(target.name) == 0) {
    	    x = Integer.compare(this.origin, target.origin);
    	}//if statement 
    	else {
    	    x = this.name.compareToIgnoreCase(target.name);
    	}//else statement

    	return x;
    }

    /**
     * Getter for calories attribute.
     *
     * @return calories
     */
    public int getCalories() {
    	
    	return this.calories;
    }

    /**
     * Getter for name attribute.
     *
     * @return name
     */
    public String getName() {

    	return this.name;
    }

    /**
     * Getter for origin attribute.
     *
     * @return origin
     */
    public int getOrigin() {

    	return this.origin;
    }

    /**
     * Getter for string version of origin attribute.
     *
     * @return string version of origin
     */
    public String getOriginString() {

    	return ORIGINS[this.origin];
    }

    /**
     * Getter for isVegetarian attribute.
     *
     * @return isVegetarian
     */
    public boolean isVegetarian() {

    	return this.isVegetarian;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food data.
     */
    /**
     * Returns a string version of a Food object in the form:
     *
     * <pre>
    Name:       name
    Origin:     origin string
    Vegetarian: true/false
    Calories:   calories
     * </pre>
     */
    @Override
    public String toString() {
    	String foodObject = "Name: " + this.name + '\n' + "Origin: " + this.getOriginString() + '\n' + "Vegetarian: " + this.isVegetarian + '\n' + "Calories: " + this.calories;

    	return foodObject;
    }

    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|isVegetarian|calories
     * to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {
    	String foodData = this.name + "|" + this.getOriginString() + "|" + this.isVegetarian + "|" + this.calories + "|";

    	return;
    }

}
