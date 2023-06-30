package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 곱하기 혹은 더하기
 */
public class Book06 {
    public static String str;

    public static long solution() {
        // 만들어질 수 있는 가장 큰 수는 항상 20억 이하의 정수이므로 long 자료형 사용
        long result = 0;

        for (char c : str.toCharArray()) {
            // 연산을 위해서 형변환 처리
            int num = Integer.parseInt(Character.toString(c));

            // 0과 1은 곱하는 연산보다 더하는 연산이 더 큰 정수가 만들어지므로 더하기 처리
            // num, result 둘 다 분기 처리하는 이유는 첫번째 숫자가 0일 수도 있으므로
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.next();
        scan.close();

        System.out.println(solution());
    }
}
