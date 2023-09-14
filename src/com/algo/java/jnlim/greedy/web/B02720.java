package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 세탁소 사장 동혁
 */
public class B02720 {
    private static final int[] cents = {25, 10, 5, 1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int[] changes = new int[T];

        for (int i = 0; i < T; i++) {
            changes[i] = scan.nextInt();
        }

        scan.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int tmp = changes[i];

            for (int cent : cents) {
                sb.append(tmp / cent).append(" ");
                tmp %= cent;
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
