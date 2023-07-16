package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 1이 될 때까지 복습 1회차
 */
public class Review04_01 {
    public static int n;
    public static int k;

    public static void main(String[] args) {
        init();

        int result = 0;
        while (true) {
            int tmp = (n / k) * k; // 나누어 떨어지는 k의 배수
            result += (n - tmp);
            n = tmp;

            if (n < k) {
                break;
            }

            result++;
            n /= k;
        }

        System.out.println(result);
    }

    public static void init() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        scan.close();
    }
}
