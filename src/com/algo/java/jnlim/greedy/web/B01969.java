package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DNA
 */
public class B01969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chars = new char[N][M];

        for (int i = 0; i < N; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        int result = 0;

        for (int i = 0; i < M; i++) {
            Map<Character, Integer> maps = new HashMap<>();
            for (int j = 0; j < N; j++) {
                maps.put(chars[j][i], maps.getOrDefault(chars[j][i], 0) + 1);
            }

            int max = Integer.MIN_VALUE;
            char ch = ' ';

            List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(maps.entrySet());
            for (int j = 0; j < entryList.size(); j++) {
                int value = entryList.get(j).getValue();
                char key = entryList.get(j).getKey();

                if (max < value) {
                    max = value;
                    ch = key;
                } else if (max == value) {
                    char temp = key;

                    int num1 = Character.getNumericValue(ch);
                    int num2 = Character.getNumericValue(temp);

                    if (num1 > num2) {
                        ch = temp;
                    }
                }
            }

            result += N - max;
            sb.append(ch);
        }

        System.out.println(sb.toString());
        System.out.println(result);
    }
}
