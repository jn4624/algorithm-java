package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * UCPC는 무엇의 약자일까?
 * https://www.acmicpc.net/problem/15904
 */
public class B15904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ucpc[index]) index++;
            if(index == 4) break;
        }

        if(index == 4) {
            result = "I love UCPC";
        }
        else {
            result = "I hate UCPC";
        }

        System.out.println(result);
    }
}
