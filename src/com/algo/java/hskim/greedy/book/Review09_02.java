package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 05.볼링공 고르기(p315)
 */
public class Review09_02 {
    /**
     * 3회차 : 2023-07-30
     * 입력:
     * 5 3
     * 1 3 2 3 2
     * 출력: 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] weight = new int[M+1];

        for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
            weight[num] += 1;
        }

        int result = 0;
        for(int i = 1; i <= M; i++) {
            N -= weight[i];
            result += weight[i] * N;
        }

        System.out.println(result);
    }
}
