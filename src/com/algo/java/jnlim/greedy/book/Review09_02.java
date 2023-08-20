package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 볼링공 고르기 2회차 복습
 */
public class Review09_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[11];
        for (int i = 0; i < n; i++) {
            int temp = scan.nextInt();
            arr[temp] += 1;
        }

        scan.close();

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= arr[i];
            result += arr[i] * n;
        }

        System.out.println(result);
    }
}
