package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합
 * https://www.acmicpc.net/problem/1789
 */
public class B01789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long result = 0;
        long sum = 0;
        int i = 0;

        while(true) {
            i++;
            sum += i;

            if(sum > S) {
                result = i-1;
                break;
            }
        }

        System.out.println(result);
    }
}
