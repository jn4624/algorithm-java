package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 1이 될 때까지(p99)
 * 2회차 : 2023-07-29
 */
public class Review04_02 {
    /**
     * 입력: 25 5
     * 출력: 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        while(N > 2) {
            if(N % K == 0) {
                N /= K;
            }
            else {
                N -= 1;
            }

            result++;
        }

        System.out.println(result);
    }
}
