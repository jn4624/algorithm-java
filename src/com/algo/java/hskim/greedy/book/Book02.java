package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Book02 {
    /**
     * 큰 수의 법칙(p92)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while(N > 0) {
            N--;

            if(st.hasMoreTokens()) {
                list.add(Integer.valueOf(st.nextToken()));
            }
        }

        int[] data = new int[list.size()];  //{2, 4, 5, 4, 6};
        int i = 0;
        for(int a : list) {
            data[i] = a;
            i++;
        }

        Arrays.sort(data);

        int first = data[data.length-1];    //첫번째로 큰 수
        int second = data[data.length-2];   //두번째로 큰 수

        int result = 0;
        while(M > 0) {
            int count = K;
            M -= K;

            while(count > 0) {
                result += first;
                count--;
            }

            if(first > second) {
                result += second;
                M--;
            }
        }

        System.out.println("result: " + result);
    }
}
