package com.algo.java.hskim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 01.모험가 길드(p311)
 * 3회차 : 2023-07-12
 */
public class Review05_02 {
    /**
     * 입력:
     * 5
     * 2 3 1 2 2
     * 출력: 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = 0;

        /**
         * 모든 모험가의 공포도 확인.
         * 현재까지 그룹원 명수가 현재 조회하고 있는 공포도 X보다 크거나 같다면 카운트
         * 1 2 2 2 3
         * {1} group 1
         * {2, 2} group 2
         */
        int group = 0;
        for(int i = 0; i < N; i++) {
            group++;

            if(group >= arr[i]) {
                result++;
                group = 0;
            }
        }

        System.out.println(result);
    }
}
