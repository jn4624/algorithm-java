package com.algo.java.hskim.greedy.book;

import java.util.Scanner;

/**
 * 거스름돈(p87)
 * 3회차 : 2023-07-29
 */
public class Review01_02 {
    /**
     * 500원, 100원, 50원, 10원
     * 입력 : 1260
     * 출력 : 6
     */
    public static void main(String[] args) {
        int[] coin = {500, 100, 50, 10};
        int result = 0;

        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        for(int i = 0; i < coin.length; i++) {
            result += money / coin[i];
            money %= coin[i];
        }

        System.out.println(result);
    }
}
