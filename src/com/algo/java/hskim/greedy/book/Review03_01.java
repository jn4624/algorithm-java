package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review03_01 {
    /**
     * 숫자 카드 게임(p96)
     * 2회차 : 2023-07-12
     *
     * 3 3
     * 3 1 2
     * 4 1 4
     * 2 2 2
     *
     * 기대값
     * 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int index = 0;
        int[] numArr = new int[N];

        while(N > 0) {
            //N 행의 숫자값 입력받음
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());

            //해당 행에서 가장 작은 수 구하기
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());

                if(min > temp) {
                    min = temp;
                }
            }

            //행마다 가장 작은 수 배열
            numArr[index] = min;
            index++;
            N--;
        }

        int max = numArr[0];

        for(int num : numArr) {
            if(max < num) {
                max = num;
            }
        }

        System.out.println("max: " + max);
    }
}
