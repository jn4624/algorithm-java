package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5와 6의 차이
 */
public class B02864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder sb = new StringBuilder();
        sb.append(sixToFive(A) + sixToFive(B))
                .append(" ")
                .append(fiveToSix(A) + fiveToSix(B));

        System.out.println(sb.toString());
    }

    // 문자 5를 6으로 변환하여 정수형으로 리턴
    public static int fiveToSix(String str) {
        return Integer.parseInt(str.replace("5", "6"));
    }

    // 문자열 중 6을 5로 변환하여 정수형으로 리턴
    public static int sixToFive(String str) {
        return Integer.parseInt(str.replace("6", "5"));
    }
}
