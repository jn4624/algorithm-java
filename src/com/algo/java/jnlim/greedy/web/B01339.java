package com.algo.java.jnlim.greedy.web;

import java.util.*;

/**
 * 단어 수학
 */
public class B01339 {
    public static int[] alpha = new int[26];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            String word = scan.next();
            int size = word.length();
            /**
             * 입력 받은 문자열의 길이에 맞게 10의 제곱값 추출
             * size - 1은 인덱스가 0부터 시작하기 때문에
             */
            int base = (int) Math.pow(10, size - 1);

            for (int j = 0; j < size; j++) {
                /**
                 * A 부터 Z 까지 -> 0 부터 25 까지의 숫자로 매핑 처리하기 위해
                 * 입력 받은 알파벳에서 'A'의 아스키코드 값을 빼기 처리
                 */
                alpha[word.charAt(j) - 'A'] += base;
                base /= 10; // 다음 문자열의 자릿수에 맞는 제곱값을 추출하기 위해 나누기 처리
            }
        }

        // 배열을 오름차순 정렬
        Arrays.sort(alpha);

        int result = 0;
        /**
         * 범위가 25 부터 17 까지인 이유는
         * 문제에서 0부터 9까지의 숫자 중 하나로 바꿔야 한다는 범위를 지정해줬고
         * 따라서 상위 9개의 알파벳에 대해서만 연산을 수행하기 위함
         */
        for (int i = 25; i >= 17; i--) {
            result += alpha[i] * (i - 16);
        }

        System.out.println(result);
    }
}
