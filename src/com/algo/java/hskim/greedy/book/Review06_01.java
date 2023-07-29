package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 02.곱하기 혹은 더하기(p312)
 * 같은 문제 3회 풀기
 */
public class Review06_01 {
    /**
     * 2회차 : 2023-07-23
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = (br.readLine()).split("");
        int result = 1;

        for(String str : strArr) {
            if(!str.equals("0")) {
                result *= Integer.parseInt(str);
            }
        }

        System.out.println(Arrays.toString(strArr));
        System.out.println(result);
    }
}
