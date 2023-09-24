package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 만들기
 */
public class B01213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();

        String name = br.readLine();

        int[] alphabets = new int[26];
        for (int i = 0; i < name.length(); i++) {
            alphabets[name.charAt(i) - 'A']++;
        }

        int oddCount = 0; // 홀수 알파벳 개수
        char center = '0'; // 홀수 알파벳 문자열

        for (int i = 0; i < alphabets.length; i++) {
            // 홀수 알파벳 체크
            if (alphabets[i] != 0 && alphabets[i] % 2 != 0) {
                oddCount++;
                center = (char) (i + 'A');
            }
        }

        // 홀수의 알파벳이 1개 이상일 경우 팰린드롬 문자열이 될 수 없으므로 종료
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < alphabets.length; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                front.append((char) (i + 'A'));
            }
        }

        StringBuffer temp = new StringBuffer(front.toString());
        back.append(temp.reverse().toString());

        if (oddCount == 1) {
            front.append(center);
        }

        result.append(front.toString())
                .append(back.toString());

        System.out.println(result.toString());
    }
}
