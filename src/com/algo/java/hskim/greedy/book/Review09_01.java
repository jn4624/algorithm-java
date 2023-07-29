package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 05.볼링공 고르기(p315)
 * 같은 문제 3회 풀기
 */
public class Review09_01 {
    /**
     * 2회차 : 2023-07-23
     */
    public static void main(String[] args) {
        int result = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] weightArr = new int[N];
        int num = 0;

        for (int i = 0; i < N; i++) {
            num = sc.nextInt();
            weightArr[num] += 1;
        }

        for(int i = 1; i <= M; i++) {
            N -= weightArr[i];
            result += (weightArr[i] * N);
        }

        System.out.println(result);
    }
}
