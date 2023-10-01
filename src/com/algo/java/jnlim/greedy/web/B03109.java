package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빵집
 */
public class B03109 {
    public static char[][] map;
    public static int R;
    public static int C;
    public static int result;
    public static int[] dr = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            check(0, i);
        }

        System.out.println(result);
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + 1;
            int ny = y + dr[i];

            if (nx < 0 || nx > C - 1 || ny < 0 || ny > R - 1) {
                continue;
            }

            if (map[ny][nx] == '.') {
                if (nx == C - 1) {
                    result++;
                    return true;
                }

                map[ny][nx] = '-';

                if (check(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}
