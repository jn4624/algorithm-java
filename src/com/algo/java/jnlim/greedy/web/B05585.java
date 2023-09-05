package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 거스름돈
 */
public class B05585 {
    public static final int[] coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int money = 1000 - scan.nextInt();
        scan.close();

        int count = 0;
        for (int coin : coins) {
            count += (money / coin);
            money %= coin;
        }

        System.out.println(count);
    }
}
