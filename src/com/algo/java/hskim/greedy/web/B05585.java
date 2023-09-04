package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 거스름돈
 * https://www.acmicpc.net/problem/5585
 */
public class B05585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay = Integer.parseInt(br.readLine());
        int money = 1000 - pay;

        int[] coinTypes = {500, 100, 50, 10, 5, 1};
        int result = 0;

        for(int coin : coinTypes) {
            result += money / coin;
            money %= coin;
        }

        System.out.println(result);
    }
}
