package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사과 담기 게임
 */
public class B02828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int result = 0;
        int left = 0;
        int right = left + M - 1;

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine()) - 1;

            if (left > apple) {
                int diff = left - apple;
                result += diff;
                left -= diff;
                right -= diff;
            } else if (right < apple) {
                int diff = apple - right;
                result += diff;
                right += diff;
                left += diff;
            }
        }

        System.out.println(result);
    }
}
