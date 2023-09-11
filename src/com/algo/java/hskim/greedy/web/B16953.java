package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A → B
 * https://www.acmicpc.net/problem/16953
 */
public class B16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int result = 1;

        //top-down
        while(A != B) {
            if(B < A) {
                result = -1;
                break;
            }

            int num = (int) (B % 10);

            if(B % 10 == 1) {
                B /= 10;
            }
            else if(B % 2 == 0) {
                B /= 2;
            }
            else if(num % 2 != 0) { //3,5,7,9
                result = -1;
                break;
            }
            else {
                result = -1;
                break;
            }

            result += 1;
        }

        System.out.println(result);


        /** idea
         * 실패한 방법 : 시간초과
         1. B의 일의 자리가 1이라면 1을 제외한 숫자를 반환 후 B/=10
         2. B % 2 == 0일 경우 B/=2
         3. 예외 케이스
            3-1. 일의 자리가 홀수일 경우
            3-2. top-down 방식인만큼 B < A 졌을 경우

         int num = (int) (B % 10);

         if(num != 1 && num % 2 != 0) {
            System.out.println(-1);
            return;
         }

         int result = 1;

         while(A != B) {
            num = (int) (B % 10);

            if(num == 1) {
                B /= 10;
            }
            else if(B % 2 == 0) {
                B /= 2;
            }
            else if(num % 2 != 0 || B < A) {  // 3,5,7,9
                result = -1;
                break;
            }

            result += 1;

            System.out.println("B: " + B + " = " + result);
        }

        System.out.println(result);
         */
    }
}
