package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세탁소 사장 동혁
 * https://www.acmicpc.net/problem/2720
 */
public class B02720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] coin = {25, 10, 5, 1};

        for(int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < coin.length; j++) {
                sb.append(C / coin[j] + " ");
                C %= coin[j];
            }

            System.out.println(sb.toString());
        }
    }
}
