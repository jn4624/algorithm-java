package com.algo.java.jnlim.greedy.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 신입 사원
 */
public class B01946 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();

            List<Grade> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int document = scan.nextInt();
                int interview = scan.nextInt();

                list.add(new Grade(document, interview));
            }

            Collections.sort(list);

            int passCount = 0;
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < N; k++) {
                if (list.get(k).getInterview() < min) {
                    passCount++;
                    min = list.get(k).getInterview();
                }
            }

            System.out.println(passCount);
        }
    }
}

class Grade implements Comparable<Grade> {
    private int document;
    private int interview;

    public Grade(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

    public int getInterview() {
        return interview;
    }

    @Override
    public int compareTo(Grade o) {
        // document 오름차순 정렬
        return this.document - o.document;
    }
}
