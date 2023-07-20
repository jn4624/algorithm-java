package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 거스름돈 복습 1회차
 */
public class Review01_01 {
    private static final int[] coins = {500, 100, 50, 10};
    private static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.close();

        int result = 0;
        for (int coin : coins) {
            result += (n / coin);
            n %= coin;
        }

        System.out.println(result);
    }
}
