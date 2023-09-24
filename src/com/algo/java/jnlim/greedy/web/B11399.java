package com.algo.java.jnlim.greedy.web;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM
 */
public class B11399 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scan.nextInt();
        }

        scan.close();

        Arrays.sort(p);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (i + 1); j++) {
                sum += p[j];
            }
        }

        System.out.println(sum);
    }
}
