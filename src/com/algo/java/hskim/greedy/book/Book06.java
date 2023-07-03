package com.algo.java.hskim.greedy.book;

import java.io.*;

public class Book06 {
    /**
     * 곱하기 혹은 더하기(p312)
     * 같은 문제 3회 풀기
     */

    /**
     * 1회차 : 2023-07-01
     */
    public static int solution01(String str) {
        String[] numStrArr = str.split("");

        int result = 1;
        int isZero = 0;
        int temp = 0;

        for(int i = 0; i < numStrArr.length; i++) {
            temp = Integer.parseInt(numStrArr[i]);

            //0 판단
            if(temp == 0) {
                i++;
                isZero = temp;
                temp = Integer.parseInt(numStrArr[i]);
                result *= (isZero + temp);
            }
            else {
                result *= temp;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = br.readLine();

        br.close();
        bw.write(String.valueOf(solution01(numStr)));
        bw.flush();
        bw.close();
    }
}