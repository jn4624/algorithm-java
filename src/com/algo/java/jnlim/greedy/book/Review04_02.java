package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 1이 될 때까지 복습 2회차
 */
public class Review04_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        scan.close();

        int result = 0;
        while (true) {
            int temp = (n / k) * k; // k의 배수 추출
            result += (n - temp);
            n = temp;

            if (n < k) {
                break;
            }

            result++;
            n /= k;
        }

        result += (n - 1);

        System.out.println(result);
    }
}
