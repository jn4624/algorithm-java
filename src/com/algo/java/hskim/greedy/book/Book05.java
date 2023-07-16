package com.algo.java.hskim.greedy.book;

import java.io.*;
import java.util.Arrays;

public class Book05 {
    /**
     * 01.모험가 길드(p311)
     * 같은 문제 3회 풀기
     */

    /**
     * 1회차 : 2023-07-01
     * 1. 모험가 N명 ASC 또는 DESC 정렬
     * 2. 선택한 모험가의 공포도 크기만큼 그룹원 구하기
     * 3. 공포도 크기만큼 그룹원을 모집 완료되면 새로운 그룹 생성
     *
     * 잘 못 이해하고 작성한 내용
     * 1. 공포도 X 최소값
     * 2. 공포도 X 최소 2명 이상
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String fearRateStr = br.readLine();

        int result = 0;

        String[] fearRateArr = fearRateStr.split(" ");

        //1. 모험가 N명 ASC 또는 DESC 정렬
        Arrays.stream(fearRateArr).sorted();

        //2. 선택한 모험가의 공포도 크기만큼 그룹원 구하기
        for(int i = 0; i < fearRateArr.length; i++) {
            int fearRate = Integer.parseInt(fearRateArr[i]);

            //3. 공포도 크기만큼 그룹원을 모집 완료되면 새로운 그룹 생성
            if(n >= fearRate) {
                n -= fearRate;

                if(fearRate > 1) {
                    i += fearRate;
                }

                result++;
            }
        }

        br.close();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}