package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 숫자 카드 게임 복습 1회차
 */
public class Review03_01 {
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, scan.nextInt());
            }

            max = Math.max(max, min);
        }

        scan.close();

        System.out.println(max);
    }
}
