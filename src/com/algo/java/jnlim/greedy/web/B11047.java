package com.algo.java.jnlim.greedy.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 동전 0
 */
public class B11047 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long k = scan.nextLong();

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(scan.nextInt());
        }

        scan.close();

        // 동전이 큰 수부터 계산될 수 있도록 정렬
        Collections.sort(coins, Collections.reverseOrder());

        int count = 0;
        for (int coin : coins) {
            if (k < coin) {
                continue;
            }

            count += (k / coin);
            k %= coin;
        }

        System.out.println(count);
    }
}
