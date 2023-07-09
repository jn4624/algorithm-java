package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 문자열 뒤집기
 */
public class Book07 {
    public static String str;
    public static int zeroCount;
    public static int oneCount;

    public static int solution() {
        // 문자열의 첫번째 원소에 대한 처리
        if (str.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        // 두번째 원소부터 모든 원소 확인
        for (int i = 0; i < str.length() - 1; i++) {
            // 직전 원소와 다음 원소가 다를 경우
            if (str.charAt(i) != str.charAt(i + 1)) {
                // 다음 원소의 값이 0에 해당하면 zeroCount 증가
                if (str.charAt(i + 1) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        // 두 count 중 가장 작은 count 리턴
        return Math.min(zeroCount, oneCount);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        scan.close();

        System.out.println(solution());
    }
}
