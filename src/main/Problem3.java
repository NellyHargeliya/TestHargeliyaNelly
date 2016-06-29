package main;

import java.util.*;

import static java.util.Arrays.*;

/**
 * Created by Nelly on 17.06.2016.
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
        Map<ArrayList<Long>, Long> myMap = new TreeMap<>(new Comparator<ArrayList<Long>>() {
            @Override
            public int compare(ArrayList<Long> o1, ArrayList<Long> o2) {
                long one = 1;
                for (long arr : o1) one *= arr;

                long two = 1;
                for (long arr : o2) two *= arr;
                return (int) (one - two);
            }
        });
        int sizeArray = array.size();
        for (int i = 0; i < sizeArray; i++) {
            long tempProduct = 1;
            for (long arr : array.get(i)) tempProduct *= arr;
            myMap.put(array.get(i), tempProduct);
        }

        List<Long> listMax2 = Collections.max(myMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        //  Set<Map.Entry<ArrayList<Long>, Long>> h = myMap.entrySet();

        System.out.println(myMap);
        int sizeListMax = listMax2.size();
        long[] productMax = new long[sizeListMax];
        for (int i = 0; i < sizeListMax; i++) productMax[i] = listMax2.get(i);

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
        for (int i = 0; i < lenghtNum; i++)arr[i] = arrayNum[i];

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
