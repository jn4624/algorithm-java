package com.algo.java.jnlim.greedy.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 큰 수의 법칙
 */
public class Book02 {
    public int solution(int n, int m, int k, int[] numbers) {
        Arrays.sort(numbers);

        int firstMaxNumber = numbers[n - 1];
        int secondMaxNumber = numbers[n - 2];

        int firstCycle = ((m / (k + 1)) * k) + (m % (k + 1));
        int secondCycle = (m - firstCycle);

        int maxNumber = firstCycle * firstMaxNumber;
        maxNumber += secondCycle * secondMaxNumber;

        return maxNumber;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 배열의 크기
        int m = scan.nextInt(); // 숫자가 더해지는 횟수
        int k = scan.nextInt(); // 초과하여 더해질 수 없는 횟수

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }

        scan.close();

        Book02 book02 = new Book02();
        System.out.println(book02.solution(n, m, k, numbers));
    }
}
