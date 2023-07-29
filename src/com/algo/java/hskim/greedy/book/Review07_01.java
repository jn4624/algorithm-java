package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 03.문자열 뒤집기(p313)
 * 같은 문제 3회 풀기
 */
public class Review07_01 {
    /**
     * 2회차 : 2023-07-23
     * 다시풀기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;

        String[] strArr = S.split("");
        String curr = "";
        String next = "";

        for(int i = 0; i < strArr.length; i++) {
            curr = strArr[i];
            next = "";

            if(i != strArr.length-1) {
                next = strArr[i+1];
            }

            if(!curr.equals(next)) {
                if(next.equals("1")) {
                    oneCount++;
                }
                else {
                    zeroCount++;
                }
            }
        }

        System.out.println("zeroCount: " + zeroCount);
        System.out.println("oneCount: " + oneCount);
        System.out.println(Math.min(zeroCount, oneCount));
    }
}
