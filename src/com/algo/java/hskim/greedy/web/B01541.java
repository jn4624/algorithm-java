package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */
public class B01541 {
    /**
     * 55-50+40     -35
     * 10+20+30+40  100
     * 00009-00009  0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = Integer.MAX_VALUE;

        while(st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer stTemp = new StringTokenizer(st.nextToken(), "+");

            while(stTemp.hasMoreTokens()) {
                temp += Integer.parseInt(stTemp.nextToken());
            }

            if(result == Integer.MAX_VALUE) {
                result = temp;
            }
            else {
                result -= temp;
            }
        }

        System.out.println(result);
    }
}
