package main;

public class Main {

    public static void main(String[] args) {
        Problem3 pr = new Problem3();
        for (long arr : pr.maxProduct(12)) {
            System.out.print(arr + " ");
        }
    }
}
