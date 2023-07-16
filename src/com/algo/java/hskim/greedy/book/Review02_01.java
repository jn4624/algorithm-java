package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review02_01 {
    /**
     * 큰 수의 법칙(p92)
     * 2회차 : 2023-07-12
     *
     * 5 8 3
     * 2 4 5 4 6
     * 기대값 46
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[st.countTokens()];

        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int first = numArr[0];
        int second = numArr[1];
        int index = 0;

        for(int j = 0; j < numArr.length; j++) {
            if(first < numArr[j]) {
                second = first;
                first = numArr[j];
                index = j;
            }
            if(second < numArr[j] && first > numArr[j]) {
                second = numArr[j];
            }
            if(second < numArr[j] && first == numArr[j] && j != index) {
                second = numArr[j];
            }
            if(second > first) {
                int temp = first;
                first = second;
                second = temp;
            }
        }

        int result = 0;

        while(M > 0) {
            if(M > K) {
                result += (first * K);
            }
            else {
                result += (first * M);
            }
            M -= K;

            if(M > 0) {
                result += second;
            }
            M -= 1;
        }

        System.out.println("result: " + result);
    }
}
