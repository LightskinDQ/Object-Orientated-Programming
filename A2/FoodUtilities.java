package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author your name, id, email here
 * @version 2023-05-07
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {
    	int average = 0;
    	int total = 0;
    	int size = foods.size();
    	for (int i = 0; i < size; i++ ) {
    		total = total + foods.get(i).getCalories();
    	}
    	average = total / size;
	return average;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {
    	int average = 0;
    	int total = 0;
    	int numFood = 0;
    	
    	if (foods.isEmpty() == false) {
    	    for (Food food : foods) {
    	    	if (food.getOrigin() == origin) {
    	    		total = total + food.getCalories();
    	    		numFood++;
    	    	}//if statement 2
    	    }//for loop
    	    average = total / numFood;
    	}//if statement 1
    	
    	return average;
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	
    	for (Food food : foods) {
    	    if (food.getOrigin() == origin) {
    		foodList.add(food);
    	    }//if statement
    	}// for loop
    	
    	return foodList;

    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {
    	boolean veggie;
    	
    	System.out.print("Name: ");
    	String name = keyboard.nextLine();
    	
    	System.out.println(Food.originsMenu());
    	System.out.print("Origin: ");
    	int origin = keyboard.nextInt();
    	
    	System.out.print("Vegetarian (YES/NO): ");
    	String vegetarian = keyboard.next();
    	
    	System.out.print("Calories: ");
    	int calories = keyboard.nextInt();
    	
    	if (origin > 11 || origin < 0) {
    		return null;
    	}//if statement 1
    	
    	if (vegetarian.toUpperCase().compareTo("YES") == 0) {
    		veggie = true;
    	}//if statement 2
    	
    	else {
    		veggie = false;
    	}//else statement
    	
    	Food food = new Food(name, origin, veggie, calories);
    	
	return food;
    }


    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	
    	for (Food food : foods) {
    	    if (food.isVegetarian() == true) {
    		foodList.add(food);
    	    }//if statement
    	}//for loop

    	return foodList;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {
    	int startIndex = line.indexOf("|");
    	int nextIndex = line.indexOf("|", startIndex + 1);
    	String name = line.substring(0, startIndex);
    	int origin = Integer.parseInt(line.substring(startIndex + 1, nextIndex));
    	startIndex = nextIndex;
    	nextIndex = line.indexOf("|", startIndex + 1);
    	boolean vege = Boolean.parseBoolean(line.substring(startIndex + 1, nextIndex));
    	startIndex = nextIndex;
    	int cals = Integer.parseInt(line.substring(startIndex + 1));
    	Food newFood = new Food(name, origin, vege, cals);

    	return newFood;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	
    	while (fileIn.hasNextLine()) {
    	    String line = fileIn.nextLine();
    	    foodList.add(readFood(line));
    	}//while loop

    	return foodList;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {
    	ArrayList<Food> list = new ArrayList<Food>();
    	int size = foods.size();
    	
    	for (int i = 0; i < size; i++) {
    		if (origin == -1 || foods.get(i).getOrigin() == origin) {
    			if (maxCalories == 0 || foods.get(i).getCalories() <= maxCalories) {
    				if (isVegetarian == false)
    					list.add(foods.get(i));
    				else if (foods.get(i).isVegetarian() == true) {
    					list.add(foods.get(i));
    				}//elif statement
    			}//if statement 2
    		}//if statement 1
    	}//for loop

	return list;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {
    	for (int i = 0; i < foods.size(); i++) {
    	    ps.println(foods.get(i));
    	}//for loop
    	
    	return;
    }
}
