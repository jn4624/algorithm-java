package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 뒤집기
 * https://www.acmicpc.net/problem/1439
 * 그리기, 문자열
 */
public class B01439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        StringTokenizer st_zero = new StringTokenizer(sb.toString(), "00");
        StringTokenizer st_one = new StringTokenizer(sb.toString(), "11");

        int zero = st_zero.countTokens();
        int one = st_one.countTokens();

        int result = zero > one ? one : zero;
        System.out.println(result);
    }
}
