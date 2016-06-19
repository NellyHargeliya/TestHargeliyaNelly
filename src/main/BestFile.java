package main;

/**
 * Created by Nelly on 16.06.2016.
 */
public interface BestFile {
    String fitPlusMinus(String digits, long expectedResult);

    String fit(String digits, long expectedResult);

    String fitBraces(String digits, long expectedResult);

}
