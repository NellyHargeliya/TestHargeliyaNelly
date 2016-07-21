package main;

import java.util.*;

import static java.util.Arrays.*;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

/**
 * Task 3
 * #Created by Nelly#
 * Given a natural number n. It is necessary to find a set of distinct positive terms,
 * which add up to n and satisfies the given conditions
 */
public class Problem3 implements Summands {
    private ArrayList<ArrayList<Long>> allArraysPratition = new ArrayList<>();

    private void setAllArraysPratition(ArrayList<Long> arr) {
        allArraysPratition.add(arr);
    }

    public ArrayList<ArrayList<Long>> getAllArraysPratition() {
        return allArraysPratition;
    }

    @Override
    public long[] maxProduct(long n) {
        ArrayList<ArrayList<Long>> array = numberPartition(n);
        return maxProductArray(array);
    }


    private long[] maxProductArray(ArrayList<ArrayList<Long>> array) {
        int sizeArray = array.size();
        ArrayList<Long> tempArray = new ArrayList<>();
        long maxProduct = 1;
        for (int i = 0; i < sizeArray; i++) {
            long tempProduct = 1;
            for (long arr : array.get(i)) tempProduct *= arr;
            if (tempProduct >= maxProduct) {
                maxProduct = tempProduct;
                tempArray = array.get(i);
            }
        }
        long[] maxArray = new long[tempArray.size()];
        for (int i = 0; i < tempArray.size(); i++) maxArray[i] = tempArray.get(i);

        return maxArray;
    }

    @Override
    public long[][] allMaxProduct(long n) {
        ArrayList<ArrayList<Long>> array = numberPartition(n);

        Map<ArrayList<Long>, Long> myMap = new HashMap<>();
        int sizeArray = array.size();
        for (int i = 0; i < sizeArray; i++) {
            long tempProduct = 1;
            for (long arr : array.get(i)) tempProduct *= arr;
            myMap.put(array.get(i), tempProduct);
        }

        List<Long> listMax2 = Collections.max(myMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        long[][] res = new long[1][listMax2.size()];
        for (int j = 0, i = 0; i < listMax2.size(); i++) {
            res[j][i] = listMax2.get(i);
        }
        return res;
    }

    @Override
    public long[] maxPairProduct(long n) {
        ArrayList<ArrayList<Long>> array = numberPartition(n);

        Map<ArrayList<Long>, Long> myMap = new HashMap<>();
        int sizeArray = array.size();
        for (int i = 0; i < sizeArray; i++) myMap.put(array.get(i), pairProduct(array.get(i)));

        List<Long> listMax2 = Collections.max(myMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        long[] res = new long[listMax2.size()];
        for (int i = 0; i < listMax2.size(); i++) res[i] = listMax2.get(i);
        return res;
    }

    private long pairProduct(ArrayList<Long> arr) {
        int size = arr.size();
        long pairArrayProduct = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                pairArrayProduct += arr.get(i) * arr.get(j);
            }
        }

        return pairArrayProduct;
    }

    public void addArrayPartition(long[] arrayNum, long lenghtNum) {
        Long[] arr = new Long[(int) lenghtNum];
        for (int i = 0; i < lenghtNum; i++) arr[i] = arrayNum[i];

        ArrayList<Long> arrayList = new ArrayList<>(asList(arr));
        setAllArraysPratition(arrayList);
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

    private ArrayList<ArrayList<Long>> numberPartition(long number) {
        long lenghtNum = number;
        long[] arrayNum = new long[(int) number];
        for (int i = 0; i < number; i++) arrayNum[i] = 1;

        addArrayPartition(arrayNum, number);
        do {
            lenghtNum = nextLenght(arrayNum, lenghtNum);
            addArrayPartition(arrayNum, lenghtNum);
        } while (lenghtNum > 1);
        return getAllArraysPratition();
    }
}

