package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 거스름돈
 */
public class C03301 {
    public static int[] coinTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static int payments;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        payments = scan.nextInt();
        scan.close();

        int result = 0;
        for (int coin : coinTypes) {
            result += (payments / coin);
            payments %= coin;
        }

        System.out.println(result);
    }
}
