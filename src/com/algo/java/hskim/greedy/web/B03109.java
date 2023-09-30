package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빵집
 * https://www.acmicpc.net/problem/3109
 * 다시
 * 키워드 : dfs, 재귀
 */
public class B03109 {
    static int R,C = 0;
    static int count = 0;
    static char[][] map;
    static boolean[][] memo;
    static int[] dr= {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        memo = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        //0 ~ (R-1)행까지 검사
        for(int i = 0; i < R; i++) {
            if(dfs(i,0)) count++;
        }

        System.out.println(count);
    }

    static boolean dfs(int r, int c) {
        for(int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + 1;

            //map 영역 밖인지 체크
            if(nr < 0 || nc < 0 || nr > R-1 || nc > C-1) continue;

            if(memo[nr][nc] == false && map[nr][nc] =='.') {
                memo[nr][nc] = true;

                //현재 행의 마지막 열까지 왔다면
                if(nc == C-1) return true;
                if(dfs(nr, nc)) return true;
            }
        }

        return false;
    }
}

