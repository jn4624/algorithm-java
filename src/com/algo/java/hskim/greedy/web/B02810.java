package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 컴홀더
 * https://www.acmicpc.net/problem/2810
 * 다시
 */
public class B02810 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("");
        int count = 1;

        for (int i = 0; i < num; i++) {
            if(s[i].equals("S")) count++;
            else{
                i++;
                count++;
            }
        }

        System.out.println(num> count? count: num);

    }
}
