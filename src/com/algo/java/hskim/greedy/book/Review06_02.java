package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 02.곱하기 혹은 더하기(p312)
 */
public class Review06_02 {
    /**
     * 3회차 : 2023-07-30
     *
     * 입력: 02984
     * 출력: 576
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] arr = S.split("");
        int result = Integer.parseInt(arr[0]);

        for(int i = 1 ; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);

            if(temp < 2 || result < 2) {
                result += temp;
            }
            else {
                result *= temp;
            }
        }

        System.out.println(result);
    }
}
