package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 공항
 */
public class B10775 {
    public static int[] gates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        gates = new int[G + 1];
        for (int i = 1; i < G + 1; i++) {
            gates[i] = i;
        }

        int P = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < P; i++) {
            int l = Integer.parseInt(br.readLine());

            if (find(l) == 0) {
                break;
            }

            count++;
            union(find(l), find(l) - 1);
        }

        System.out.println(count);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        gates[a] = b;
    }

    public static int find(int x) {
        if (x == gates[x]) {
            return x;
        }

        return gates[x] = find(gates[x]);
    }
}
