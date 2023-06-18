package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 거스름돈
 */
public class Book01 {
    public static final int[] coins = {500, 100, 50, 10};

    public int solution(int money) {
        int resChangeMoney = 0;

        for (int coin : coins) {
            resChangeMoney += (money / coin);
            money %= coin;
        }

        return resChangeMoney;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();
        scan.close();

        Book01 book01 = new Book01();
        System.out.println(book01.solution(money));
    }
}
