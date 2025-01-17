package cp213;

/**
 * @author Your name and id here
 * @version 2023-05-23
 */
public class Numbers {

    /**
     * Determines closest value of two values to a target value.
     *
     * @param target the target value
     * @param v1     first comparison value
     * @param v2     second comparison value
     * @return one of v1 or v2 that is closest to target, v1 is the value chosen if
     *         v1 and v2 are an equal distance from target
     */
    public static double closest(final double target, final double v1, final double v2) {
    	double closeV1 = 0.0;
    	double closeV2 = 0.0;
    	double closestNum = 0.0;

    	closeV1 = target + v1;
    	closeV2 = target + v2;

    	if (closeV1 <= closeV2) {
    	    closestNum = v1;
    	}//if 1 
    	else {
    	    closestNum = v2;
    	}// if 2

    	return closestNum;

    }

    /**
     * Determines if n is a prime number. Prime numbers are whole numbers greater
     * than 1, that have only two factors - 1 and the number itself. Prime numbers
     * are divisible only by the number 1 or itself.
     *
     * @param n an integer
     * @return true if n is prime, false otherwise
     */
    public static boolean isPrime(final int n) {
    	boolean prime  = true;
    	if (n < 1) {
    		prime = false;
    	}//if num 1
    	else {
    		for (int i = 2;i <= n /2;i++) {
    			if (n % i == 0) {
    				prime = false;
    			}//if num 2
    		}//for loop
    	}// else

	return prime;
    }

    /**
     * Sums and returns the total of a partial harmonic series. This series is the
     * sum of all terms 1/i, where i ranges from 1 to n (inclusive). Ex:
     *
     * n = 3: sum = 1/1 + 1/2 + 1/3 = 1.8333333333333333
     *
     * @param n an integer
     * @return sum of partial harmonic series from 1 to n
     */
    public static double sumPartialHarmonic(final int n) {
    	double sum = 0.0;
    	  for(double i = 1; i <= n; i++) {
    		  sum = sum + 1 / i;
    	  }//for loop
    	      
	return sum;
    }

}
