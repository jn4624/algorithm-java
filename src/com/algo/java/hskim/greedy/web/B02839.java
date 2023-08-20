package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class B02839 {

    /**
     * 메모리 14256 kb
     * 시간 128 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sb.readLine());
        int result = 0;

        while(N > 1) {
            if(N == 4 || N == 7) {
                result = -1;
                break;
            }
            else if(N % 5 == 0) {
                result += N / 5;
                N %= 5;
            }
            else {
                N -= 3;
                result++;
            }
        }

        System.out.println(result);
    }
}
