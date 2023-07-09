package com.algo.java.jnlim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 만들 수 없는 금액
 */
public class Book08 {
    public static int n;
    public static int[] coins;

    public static int solution() {
        Arrays.sort(coins);

        int result = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때 반복문 탈출
            if (result < coins[i]) {
                break;
            }

            result += coins[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scan.nextInt();
        }

        scan.close();

        System.out.println(solution());
    }
}
