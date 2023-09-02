package com.algo.java.hskim.greedy.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 보물
 * https://www.acmicpc.net/problem/1026
 */
public class B01026 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        int num = 0;
        for(int i = 0; i < N; i++) {
            num = sc.nextInt();
            A.add(num);
        }

        for(int i = 0; i < N; i++) {
            num = sc.nextInt();
            B.add(num);
        }

        Collections.sort(A);

        int result = 0;
        int max = Collections.max(B);
        int min = A.get(0);

        for(int i = 0; i < N; i++) {
            result += (max * min);

            B.remove(B.indexOf(max));
            A.remove(A.indexOf(min));

            if(B.size() > 0 && A.size() > 0) {
                max = Collections.max(B);
                min = A.get(0);
            }
        }

        System.out.println(result);
    }
}
