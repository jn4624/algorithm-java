package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 행복 유치원
 */
public class B13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentCount = Integer.parseInt(st.nextToken());
        int groupCount = Integer.parseInt(st.nextToken());
        int[] studentHeights = new int[studentCount];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < studentCount; i++) {
            studentHeights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(studentHeights);

        List<Integer> diffList = new ArrayList<>();

        for (int i = 1; i < studentCount; i++) {
            diffList.add(studentHeights[i] - studentHeights[i - 1]);
        }

        Collections.sort(diffList);

        int result = 0;
        for (int i = 0; i < studentCount - groupCount; i++) {
            result += diffList.get(i);
        }

        System.out.println(result);
    }
}
