package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 숫자 카드 게임
 */
public class Book03 {
    public int solution() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, scan.nextInt());
            }

            max = Math.max(max, min);
        }

        scan.close();

        return max;
    }

    public static void main(String[] args) {
        Book03 book03 = new Book03();
        System.out.println(book03.solution());
    }
}
