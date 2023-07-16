package com.algo.java.jnlim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 큰 수의 법칙 복습 1회차
 */
public class Review02_01 {
    private static int n;
    private static int m;
    private static int k;
    private static int[] numbers;

    public static void main(String[] args) {
        init();

        Arrays.sort(numbers);

        int firstNumber = numbers[n - 1];
        int secondNumber = numbers[n - 2];
        int firstCount = ((m / (k + 1)) * k) + (m % (k + 1));
        int secondCount = (m - firstCount);
        int result = (firstNumber * firstCount) + (secondNumber * secondCount);

        System.out.println(result);
    }

    public static void init() {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt(); // 배열의 크기 5
        m = scan.nextInt(); // 숫자가 더해지는 횟수 8
        k = scan.nextInt(); // 초과하여 더해질 수 없는 횟수 3

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }

        scan.close();
    }
}
