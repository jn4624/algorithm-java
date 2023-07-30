package com.algo.java.hskim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 큰 수의 법칙(p92)
 * 3회차 : 2023-07-29
 */
public class Review02_02 {
    /**
     * 입력:
     * 5 8 3
     * 2 4 5 4 6
     * 출력: 46
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[N-1];
        int second = arr[N-2];
        int result = 0;

        while(M > 0) {
            M -= K + 1;
            result += (first * K) + second;
        }

        System.out.println(result);
    }
}
