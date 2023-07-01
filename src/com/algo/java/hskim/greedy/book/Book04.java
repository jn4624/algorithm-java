package com.algo.java.hskim.greedy.book;

import java.io.*;
import java.util.StringTokenizer;

public class Book04 {
    /**
     * 1이 될 때까지(p99)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        while(N >= M) {
            if(N % M != 0) {
                N -= 1;
                result++;
            }

            N = N / M;
            result++;
        }

        while(N > 1) {
            N = N - 1;
            result++;
        }

        br.close();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}