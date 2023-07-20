package com.algo.java.jnlim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 만들 수 없는 금액 1회차 복습
 */
public class Review08_01 {
    public static int n;
    public static int[] coins;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scan.nextInt();
        }

        scan.close();

        Arrays.sort(coins);

        int result = 1;
        for (int i = 0; i < n; i++) {
            if (result < coins[i]) {
                break;
            }

            result += coins[i];
        }

        System.out.println(result);
    }
}
