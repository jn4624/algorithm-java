package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 1이 될때까지
 */
public class Book04 {
    public static int n;
    public static int k;

    public static int solution() {
        int result = 0;

        while (true) {
            // 나누어 떨어질 수 있도록 k의 배수 구하기
            int tmp = (n / k) * k;
            result += (n - tmp);
            n = tmp;

            if (n < k) {
                break;
            }

            result++;
            n /= k;
        }

        // 마지막으로 남은 수에 대한 -1 처리
        result += (n - 1);

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        scan.close();

        System.out.println(solution());
    }
}
