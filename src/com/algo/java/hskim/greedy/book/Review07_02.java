package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 03.문자열 뒤집기(p313)
 */
public class Review07_02 {
    /**
     * 3회차 : 2023-07-30
     *
     * 입력: 0001100
     * 출력: 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] arr = S.split("");
        int[] cnt = new int[2];
        int index = 0;

        if(arr[0].equals("0")) cnt[0] += 1;
        else cnt[1] += 1;

        for(int i = 0; i < arr.length-1; i++) {
            if(!arr[i].equals(arr[i+1])) {
                if(arr[i+1].equals("0")) cnt[0] += 1;
                else cnt[1] += 1;
            }
        }

        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}
