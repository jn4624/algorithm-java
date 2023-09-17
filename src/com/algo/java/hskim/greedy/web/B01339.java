package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 단어 수학
 * https://www.acmicpc.net/problem/1339
 * 다시
 */
public class B01339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int[] alphabet = new int[26];

        for(String word : words) {
            int digit = word.length() - 1;
            for(char letter : word.toCharArray()) {
                int index = letter - 'A';
                alphabet[index] += (int) Math.pow(10,digit);
                digit--;
            }
        }

        Arrays.sort(alphabet);
        int index = alphabet.length-1;
        int maxNumber = 9;

        int result = 0;
        while(maxNumber >= 0 &&  alphabet[index] > 0) {
            result += alphabet[index] * maxNumber;
            maxNumber--;
            index--;
        }

        System.out.println(result);
    }
}
