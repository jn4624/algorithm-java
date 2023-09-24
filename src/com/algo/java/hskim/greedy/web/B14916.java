package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * 거스름돈
 * https://www.acmicpc.net/problem/14916
 */
public class B14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        if(n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }
        else {
            while(n > 0) {
                n -= 2;
                result++;

                if(n % 5 == 0) {
                    result += n / 5;
                    break;
                }
            }
        }

        if(n < 0) {
            result = -1;
        }

        System.out.println(result);

        /** idea
         * 실패한 방법 : 89% 에서 틀림..
         1. n이 짝수이면 5로 나누고 나머지 값을 2로 나눈다.
         2. n이 홀수이면 n - (5 * a) 가 짝수가 될 때까지 5 * a를 진행한다.
         2-1. n이 짝수가 되면 2로 나눈다.

        if(n < 5) {
            if(n > 0) {
                if(n % 2 == 0) {
                    System.out.println(n / 2);
                    return;
                }
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        if(n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }

        int pow = n / 5;
        boolean isEven = (n - (5 * pow)) % 2 == 0 ? true : false;

        while(!isEven) {
            if(pow < 1) break;

            pow--;
            isEven = (n - (5 * pow)) % 2 == 0 ? true : false;
        }

        int result = 0;

        n -= (5 * pow);
        result = pow + (n / 2);
        n %= 2;

        if(n < 0 || n == 1 || n == 3) result = -1;

        System.out.println(result);
         */
    }
}
