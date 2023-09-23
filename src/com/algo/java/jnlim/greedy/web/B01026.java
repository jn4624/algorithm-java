package com.algo.java.jnlim.greedy.web;

import java.util.*;

/**
 * 보물
 */
public class B01026 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(scan.nextInt());
        }

        for (int i = 0; i < n; i++) {
            b.add(scan.nextInt());
        }

        scan.close();

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        int s = 0;
        for (int i = 0; i < n; i++) {
            s += (a.get(i) * b.get(i));
        }

        System.out.println(s);
    }
}
