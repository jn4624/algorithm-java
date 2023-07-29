package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C02001 {
    public static void main(String[] args) throws IOException {
        /**
         * 최소 대금
         * https://codeup.kr/problem.php?id=2001
         *
         * 입력
         * 800 파스타
         * 700 파스타
         * 900 파스타
         * 198 생과일 쥬스
         * 330 생과일 쥬스
         *
         * 출력
         * 987.8
         */

        /**
         * 추천 파스타(1/3)와 생과일 쥬스(1/2) 세트 메뉴
         * 파스타 + 생과일 쥬스 + 10%
         * int -> float
         */
        double result = 0.0f;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = 5;
        int pasta = Integer.MAX_VALUE;
        int juice = Integer.MAX_VALUE;

        while(length > 0) {
            int temp = Integer.parseInt(br.readLine());

            if(length > 2) {
                if(pasta > temp) {
                    pasta = temp;
                }
            }
            else {
                if(juice > temp) {
                    juice = temp;
                }
            }

            length--;
        }

        result = (pasta + juice) + ((pasta + juice) * 0.1);
        System.out.println("pasta: " + pasta);
        System.out.println("juice: " + juice);
        System.out.println("result: " + result);
    }
}