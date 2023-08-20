package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 숫자 카드 게임 복습 2회차
 */
public class Review03_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, scan.nextInt()); // 한 행의 숫자 중 가장 작은 숫자 추출
            }

            max = Math.max(max, min); // 추출된 가장 작은 숫자들 중 가장 큰 숫자 추출
        }

        scan.close();

        System.out.println(max);
    }
}
