package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 햄버거 분배
 */
public class B19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean[] ate = new boolean[N];

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int startIndex = Math.max(i - K, 0);
                int endIndex = Math.min(i + K, N - 1);

                for (int j = startIndex; j <= endIndex; j++) {
                    if (arr[j] == 'H' && !ate[j]) {
                        ate[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
