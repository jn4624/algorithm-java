package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * 주유소
 * https://www.acmicpc.net/problem/13305
 */
public class B13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long result = 0;
        long[] distance = new long[N-1];
        long[] price = new long[N];

        for(int i = 0; i < distance.length; i++) {
            distance[i] = sc.nextInt();
        }
        for(int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }

        long minPrice = price[0];

        for(int i = 0; i < price.length-1; i++) {
            if(minPrice > price[i]) {
                minPrice = price[i];
            }

            result += minPrice * distance[i];
        }

        System.out.println(result);
    }
}
