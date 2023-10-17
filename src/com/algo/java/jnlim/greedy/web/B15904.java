package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UCPC는 무엇의 약자일까?
 */
public class B15904 {
    public static char[] ucpc = {'U', 'C', 'P', 'C'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int index = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                if (str.charAt(i) == ucpc[index]) {
                    count++;
                    index++;
                }
            }

            if (count == ucpc.length) {
                break;
            }
        }

        System.out.println((count == ucpc.length) ? "I love UCPC" : "I hate UCPC");
    }
}
