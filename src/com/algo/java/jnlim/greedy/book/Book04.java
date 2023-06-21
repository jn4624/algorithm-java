package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 1이 될때까지
 */
public class Book04 {
    public int solution(int n, int k) {
        int result = 0;

        while (true) {
            int tmp = (n / k) * k;
            result += (n - tmp);
            n = tmp;

            if (n < k) {
                break;
            }

            result++;
            n /= k;
        }

        result += (n - 1);

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.close();

        Book04 book04 = new Book04();
        System.out.println(book04.solution(n, k));
    }
}
