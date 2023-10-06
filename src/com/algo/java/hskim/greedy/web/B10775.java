package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 공항
 * https://www.acmicpc.net/problem/10775
 */
public class B10775 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        parents = new int[g+1];

        for(int i=1; i<g+1; i++) {
            parents[i] = i;
        }

        int p = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0; i<p; i++) {
            int l = Integer.parseInt(br.readLine());
            if(find(l) == 0) break;
            cnt++;
            union(find(l), find(l)-1);
        }

        System.out.println(cnt);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[a] = b;
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}
