package com.algo.java.hskim.greedy.book;

import java.util.Arrays;

public class Review01_01 {
    /**
     * 거스름돈(p87)
     * 2회차 : 2023-07-10
     */
    public static void main(String[] args) {
        int[] coinTypes = {500,100,50,10};
        int n = 1260;
        int result = 0;

        Arrays.sort(coinTypes);

        for(int i = coinTypes.length-1; i >= 0; i--) {
            int count = n / coinTypes[i];
            result += count;
            n %= coinTypes[i];
        }

        System.out.println("result: " + result);
    }
}
