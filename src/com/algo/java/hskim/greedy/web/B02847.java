package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임을 만든 동준이
 * https://www.acmicpc.net/problem/2847
 * 다시
 */
public class B02847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] levels = new int[n];

        // 레벨에 따른 점수 배열 저장
        for(int i = 0; i < n; i++) {
            int score = Integer.valueOf(br.readLine());
            levels[i] = score;
        }

        if(n == 1) {
            System.out.print(0);
        }
        else {
            int count = 0;

            for(int i = n - 2; i >= 0; i--) {
                int highLevel = levels[i + 1];
                int lowLevel = levels[i];

                if(lowLevel >= highLevel) {
                    count += lowLevel - (highLevel - 1);
                    levels[i] = highLevel - 1;
                }
            }

            System.out.print(count);
        }
    }
}
