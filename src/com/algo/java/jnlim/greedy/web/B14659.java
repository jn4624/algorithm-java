package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한조서열정리하러옴ㅋㅋ
 */
public class B14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MIN_VALUE;
        int count = 0;
        int prev = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (prev > next) {
                count++;
                continue;
            }

            prev = next;
            result = (result < count) ? count : result;
            count = 0;
        }

        result = Math.max(result, count);

        System.out.println(result);
    }
}
