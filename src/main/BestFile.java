package main;

/**
 * Created by Nelly
 */
public interface BestFile {
    /**
     * Returns a string  with  added arithmetic operations.
     * The operations of addition and subtraction.
     * If this is not possible, return an empty string.
     */
    String fitPlusMinus(String digits, long expectedResult);

    /**
     * Same as in the previous paragraph, but to the list of allowed operations
     * added multiplication and division.
     */
    String fit(String digits, long expectedResult);

    /**
     * Same as in the previous paragraph, in addition to arithmetic operations
     * can be add brackets.
     */

    String fitBraces(String digits, long expectedResult);

}
