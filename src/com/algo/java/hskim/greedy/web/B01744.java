package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수 묶기
 * https://www.acmicpc.net/problem/1744
 * 다시
 */
public class B01744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numArr);

        int minus = 0;
        int plus = N-1;
        long result = 0;

        for(; minus < plus; minus+=2) {
            if(numArr[minus] < 1 && numArr[minus+1] < 1) {
                result += numArr[minus] * numArr[minus+1];
            }
            else {
                break;
            }
        }

        for(; plus > 0; plus -=2) {
            if(numArr[plus] > 1 && numArr[plus-1] > 1) {
                result += numArr[plus] * numArr[plus-1];
            }
            else {
                break;
            }
        }

        for(; plus >= minus; plus--) {
            result += numArr[plus];
        }

        System.out.println(result);
    }
}
