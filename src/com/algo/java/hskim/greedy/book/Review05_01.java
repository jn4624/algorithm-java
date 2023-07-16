package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Review05_01 {
    /**
     * 01.모험가 길드(p311)
     * 2회차 : 2023-07-12
     *
     * 5
     * 2 3 1 2 2
     * 기대값
     * 2
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            al.add(sc.nextInt());
        }

        Collections.sort(al);

        int group = 0;
        int count = 0;

        for(int i = 0; i < al.size(); i++) {
            count++;

            if(count == al.get(i)) {
                count = 0;
                group++;
            }
        }

        System.out.println("group: " + group);
    }
}
