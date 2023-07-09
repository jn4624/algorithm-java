package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 볼링공 고르기
 */
public class Book09 {
    public static int n;
    public static int m;
    // m의 범위가 1부터 10까지이므로 1부터 10까지의 무게를 담을 수 있는 배열을 생성
    public static int[] arr = new int[11];

    public static int solution() {
        int result = 0;

        for (int i = 1; i <= m; i++) {
            // i 무게의 볼링공의 A가 선택할 수 있는 개수 제외 처리 후
            n -= arr[i];
            // B가 선택하는 경우의 수와 곱해주기
            result += arr[i] * n;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int tmp = scan.nextInt();
            arr[tmp] += 1;
        }

        scan.close();

        System.out.println(solution());
    }
}
