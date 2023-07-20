package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 볼링공 고르기 1회차 복습
 */
public class Review09_01 {
    public static int n;
    public static int m;
    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        for (int i=0; i<n; i++) {
            int temp = scan.nextInt();
            arr[temp] += 1;
        }

        int result = 0;
        for (int i=1; i<=m; i++) {
            n -= arr[i];
            result += arr[i] * n;
        }

        System.out.println(result);
    }
}
