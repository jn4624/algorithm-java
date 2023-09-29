package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임을 만든 동준이
 */
public class B02847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int levelCount = Integer.parseInt(br.readLine());
        int[] levels = new int[levelCount];

        for (int i = 0; i < levelCount; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int totalScore = 0;
        for (int i = levelCount - 1; i > 0; i--) {
            if (levels[i - 1] > levels[i]) {
                int calcScore = (levels[i - 1] - levels[i]) + 1;
                totalScore += calcScore;
                levels[i - 1] -= calcScore;
            } else if (levels[i] == levels[i - 1]) {
                totalScore++;
                levels[i - 1] -= 1;
            }
        }

        System.out.println(totalScore);
    }
}
