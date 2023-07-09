package com.algo.java.hskim.greedy.book;

import java.io.*;
import java.util.StringTokenizer;

public class Book09 {
    /**
     * 05.볼링공 고르기(p315)
     * 같은 문제 3회 풀기
     */

    /**
     * 1회차 : 2023-07-04
     * 5 3
     * 1 3 2 3 2
     *
     * 8 5
     * 1 5 4 3 2 4 5 2
     */
    public static int solution01(StringTokenizer st) {
        int result = 0;
        int length = st.countTokens();
        int[] numArr = new int[length];

        while(st.hasMoreTokens()) {
            numArr[numArr.length - length] = Integer.parseInt(st.nextToken());

            if(length > 1) {
                length--;
            }
        }

        for(int i = 0; i < numArr.length; i++) {
            int prev = numArr[i];

            for(int j = i+1; j < numArr.length; j++) {
                int curr = numArr[j];

                if(prev != curr) result++;
            }

            System.out.println("result: " + result);
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        br.close();
        bw.write(solution01(st));
        bw.flush();
        bw.close();
    }
}
