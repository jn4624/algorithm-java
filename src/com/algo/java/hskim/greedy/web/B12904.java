package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A와 B
 * https://www.acmicpc.net/problem/12904
 */
public class B12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());

        int result = 0;

        while(true) {
            if(S.length() == T.length()) break;

            String t = T.substring(T.length()-1);

            T.delete(T.length()-1, T.length());

            if(t.equals("B")) {
                T.reverse();
            }
        }

        if(S.toString().equals(T.toString())) result = 1;

        System.out.println(result);
    }
}
