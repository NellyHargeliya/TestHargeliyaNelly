package test;

import main.Problem1;
import main.Problem2;
import main.Problem3;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class TestProblems {


    @Test
    public void testFitPlusMinus() {
        //test fitPlusMinus
        Problem1 fit = new Problem1();
        assertTrue((fit.fitPlusMinus("123", 9)).equals("12-3"));
        assertTrue((fit.fitPlusMinus("222", 11)).equals(""));

    }

    @Test
    public void testFit() {
        //test fit
        Problem1 fit = new Problem1();
        assertTrue((fit.fit("222", 11)).equals("22/2"));
    }


    @Test
    public void testFitBraces() {
        //test fitBraces
        Problem1 fit = new Problem1();
        assertTrue((fit.fitBraces("652", 3)).equals("((6/5)+2)"));
    }

    @Test
    public void testIsLucky() {
        Problem2 lucky = new Problem2();
        //test isLucky()
        assertTrue(lucky.isLucky("123600"));
        assertTrue(lucky.isLucky("123656") == false);
    }

    @Test
    public void testCountLucky() {
        //test countLucky with long numbers
        Problem2 lucky = new Problem2();
        assertTrue(lucky.countLucky(123456123456L, 123456123465L) == (2));
    }

    @Test
    public void testCountLuckyString() {
        //test countLucky with string min and max number
        Problem2 lucky = new Problem2();
        assertTrue(lucky.countLucky("1000", "1002") == (1));

    }

    @Test
    public void maxProduct() {
        Problem3 product = new Problem3();
        long[] arr = {3, 2};
        assertArrayEquals(arr, product.maxProduct(5));
    }

    @Test
    public void allMaxProduct() {
        Problem3 product = new Problem3();
        long[][] arr = {{3, 3, 3},};
        assertArrayEquals(arr, product.allMaxProduct(9));
    }


    @Test
    public void maxPairProduct() {
        Problem3 product = new Problem3();
        long[] arr = {1, 1, 1, 1, 1, 1};
        assertArrayEquals(arr, product.maxPairProduct(6));
    }


}
