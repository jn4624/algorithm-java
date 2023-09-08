package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 전자레인지
 * https://www.acmicpc.net/problem/10162
 */
public class B10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /**
         * 5분       1분      10초
         * 300초     60초     10초
         */

        int[] buttons = {300, 60, 10};
        int[] count = new int[3];

        for(int i = 0; i < buttons.length; i++) {
            int button = buttons[i];

            while(button <= T) {
                T -= button;
                count[i] += 1;
            }
        }

        if(T != 0) {
            System.out.println(-1);
        }
        else {
            String result = "";

            for(int num : count) {
                String temp = String.valueOf(num);

                if(result.equals("")) {
                    result += temp;
                }
                else {
                    result += " " + temp;
                }
            }
            System.out.println(result);
        }
    }
}
