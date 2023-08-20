package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 곱하기 혹은 더하기 2회차 복습
 */
public class Review06_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        long result = 0;
        for (char c : str.toCharArray()) {
            int temp = Integer.parseInt(Character.toString(c));

            if (temp <= 1 || result <= 1) { // 1이하의 숫자는 곱하기보다 더하기가 더 큰 수를 만들 수 있으므로 더하기 처리
                result += temp;
            } else {
                result *= temp;
            }
        }

        System.out.println(result);
    }
}
