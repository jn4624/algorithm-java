package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 숫자 카드 게임(p96)
 * 3회차 : 2023-07-29
 */
public class Review03_02 {
    /**
     * 입력:
     * 3 3
     * 3 1 2
     * 4 1 4
     * 2 2 2
     * 출력: 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        for(int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < M; j++) {
                int temp = sc.nextInt();

                if(min > temp) {
                    min = temp;
                }
            }

            if(result < min) {
                result = min;
            }
        }

        System.out.println(result);
    }
}
