package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 센서
 * https://www.acmicpc.net/problem/2212
 */
public class B02212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sensor = new int[N];
        int[] distances = new int[N-1];

        for(int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        for(int i = 0; i < sensor.length-1; i++) {
            int distance = sensor[i+1] - sensor[i];
            distances[i] = distance;
        }

        Arrays.sort(distances);

        int result = 0;

        for(int i = 0; i < N-K; i++) {
            result += distances[i];
        }

        System.out.println(result);
    }
}
