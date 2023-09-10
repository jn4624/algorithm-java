package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 30
 * https://www.acmicpc.net/problem/10610
 */
public class B10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] numArr = N.toCharArray();

        Arrays.sort(numArr);

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = numArr.length-1; i >= 0; i--) {
            int temp = numArr[i] - '0';
            sum += temp;
            sb.append(temp);
        }

        if(numArr[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}
