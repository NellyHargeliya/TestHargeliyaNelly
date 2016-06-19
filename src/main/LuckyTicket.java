package main;

/**
 * Created by Nelly on 16.06.2016.
 */
public interface LuckyTicket {
    boolean isLucky(String number);

    long countLucky(long min, long max);

    long countLucky(String min, String max);
}
