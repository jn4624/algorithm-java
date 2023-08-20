package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 거스름돈 복습 2회차
 */
public class Review01_02 {
    public static void main(String[] args) {
        int[] coinType = {500, 100, 50, 10}; // 코인 종류

        Scanner scan = new Scanner(System.in);
        int payment = scan.nextInt();
        scan.close();

        int result = 0;
        for (int coin : coinType) {
            result += (payment / coin);
            payment %= coin;
        }

        System.out.println(result);
    }
}
