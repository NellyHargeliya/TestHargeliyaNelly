package main;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nelly on 17.06.2016.
 */
public class Problem3 implements Summands {
    private ArrayList<ArrayList<Long>> allArraysPratition = new ArrayList<>();

    @Override
    public long[] maxProduct(long n) {
        numberPartition(n);
        List<Long> listMax = new LinkedList<>();
        long maxProduct = 1;
        int sizeArray = allArraysPratition.size();

        for (int i = 0; i < sizeArray; i++) {
            int lenghtArray = allArraysPratition.get(i).size();
            long tempProduct = 1;
            for (int j = 0; j < lenghtArray; j++) {
                tempProduct *= allArraysPratition.get(i).get(j);
            }
            if (tempProduct > maxProduct) {
                listMax.clear();
                maxProduct = tempProduct;
                for (int j = 0; j < lenghtArray; j++) {
                    listMax.add(allArraysPratition.get(i).get(j));
                }
            }
        }
        int sizeListMax = listMax.size();
        long[] productMax = new long[sizeListMax];
        for (int i = 0; i < sizeListMax; i++) {
            productMax[i] = listMax.get(i);
        }
        return productMax;
    }

    @Override
    public long[][] allMaxProduct(long n) {
        return null;
    }

    @Override
    public long[] maxPairProduct(long n) {
        return null;
    }

    public void addArrayPartition(long[] arrayNum, long lenghtNum) {
        Long[] arr = new Long[(int) lenghtNum];
        for (int i = 0; i < lenghtNum; i++) {
            arr[i] = arrayNum[i];
        }
        ArrayList<Long> arrayList = new ArrayList<>(Arrays.asList(arr));
        allArraysPratition.add(arrayList);
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
