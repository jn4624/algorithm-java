package com.algo.java.hskim.greedy.book;

public class Book01 {
    /**
     * 거스름돈(p87)
     * 1회차 : 2023-06-19
     */
    public static void main(String[] args) {
        int count = 0;
        int[] coinTypes = {500,100,50,10};
        int n = 1260;

        for(int i = 0; i < coinTypes.length; i++) {
            int coin = coinTypes[i];
            count += (n / coin);
            n %= coin;
        }

        System.out.println("count: " + count);
    }
}
