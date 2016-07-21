package main;

/**
 * Created by Nelly
 */
public interface LuckyTicket {
    /***
     * Checks whether the specified ticket number happy.
     */
    boolean isLucky(String number);

    /**
     * Calculates the number of lucky tickets with different number
     * in a predetermined range including the boundary.
     * Ticket Number Length 12 digits.
     */
    long countLucky(long min, long max);

    /**
     * Calculates the number of lucky tickets with different number in a predetermined
     * range including the boundary. The length of the ticket number from 2 to 30 digits.
     * Input data include leading zeros, and are selected in such a way that the number
     * of happy numbers in a given range does not exceed Long.MAX_VALUE.
     */
    long countLucky(String min, String max);
}
