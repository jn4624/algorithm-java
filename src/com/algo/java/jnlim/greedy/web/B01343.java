package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 폴리오미노
 */
public class B01343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);

        while (true) {
            int idx = str.indexOf("XXXX");

            if (idx == -1) {
                break;
            }

            for (int i = idx; i < (idx + 4); i++) {
                sb.setCharAt(i, 'A');
                str = sb.toString();
            }
        }

        while (true) {
            int idx = str.indexOf("XX");

            if (idx == -1) {
                break;
            }

            for (int i = idx; i < (idx + 2); i++) {
                sb.setCharAt(i, 'B');
                str = sb.toString();
            }
        }

        if (str.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(str);
        }
    }
}
