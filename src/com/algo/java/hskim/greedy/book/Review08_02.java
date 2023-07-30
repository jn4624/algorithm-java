package com.algo.java.hskim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 04.만들 수 없는 금액(p314)
 */
public class Review08_02 {
    /**
     * 3회차 : 2023-07-30
     * 입력
     * 5
     * 3 2 1 1 9
     * 출력: 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = 1;

        for(int num : arr) {
            if(result >= num) result += num;
            else break;
        }

        System.out.println(result);
    }
}
