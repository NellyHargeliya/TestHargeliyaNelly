package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nelly on 17.06.2016.
 */
public class Problem3 implements Summands {
    private int around = 0;
    private long[][] arrayPratition;
    private ArrayList<Long[]> allArrays = new ArrayList<>();

    @Override
    public long[] maxProduct(long n) {
        numberPartition(n);
        long[] items;
        long[] productIt = new long[5];
        ArrayList<Long[]> array = getArrayPratition();
        List<Long> productItems = new ArrayList<>();

        long tempProduct = 1;
        long maxProduct = 1;
        for (int i = 0; i < array.size(); i++) {
            int j = 0;
            items = new long[array.size()];
            for (long a : array.get(i)) {
                tempProduct *= a;
                items[j] = a;
                System.out.print(a + " ");
                j++;
            }
            if (tempProduct >= maxProduct) {
                maxProduct = tempProduct;

                for (int k = 0; k < items.length; k++) {
                    productIt[i] = items[i];
                }
                System.out.println();
            }
        }
        return productIt;
    }

    @Override
    public long[][] allMaxProduct(long n) {

        return null;
    }

    @Override
    public long[] maxPairProduct(long n) {

        return null;
    }

    private ArrayList<Long[]> getArrayPratition() {
        for (int i = 0; i < allArrays.size(); i++) {
            for (long a : allArrays.get(i)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        return allArrays;
    }

    public void addArrayPartition(long[] arrayNum, long lenghtNum) {
        Long[] arr = new Long[(int) lenghtNum];
        for (int i = 0; i < lenghtNum; i++) {
            arr[i] = arrayNum[i];
        }
        allArrays.add(arr);
    }

    private long nextLenght(long[] arr, long l) {
        int i = (int) l - 1;
        long sum = 0;
        do {
            sum += arr[i--];
        } while (i > 0 && arr[i - 1] <= arr[i]);
        arr[i]++;
        l = i + sum;

        for (int j = i + 1; j < l; j++)
            arr[j] = 1;
        return l;
    }

    private void numberPartition(long number) {
        long lenghtNum = number;
        long[] arrayNum = new long[(int) number];
        for (int i = 0; i < number; i++) {
            arrayNum[i] = 1;
        }
        addArrayPartition(arrayNum, number);
        do {
            lenghtNum = nextLenght(arrayNum, lenghtNum);
            addArrayPartition(arrayNum, lenghtNum);
        } while (lenghtNum > 1);
    }


}
