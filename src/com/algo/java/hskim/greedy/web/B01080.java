package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬
 * https://www.acmicpc.net/problem/1080
 */
public class B01080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        char[][] matrixA = new char[N][M];
        char[][] matrixB = new char[N][M];

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            matrixA[i] = str.toCharArray();
        }

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            matrixB[i] = str.toCharArray();
        }

        for(int i = 0 ; i < N-2 ; i++){
            for(int j = 0 ; j < M-2 ; j++){
                if(matrixA[i][j] == matrixB[i][j])
                    continue;

                result++;
                for(int x = i; x < i+3; x++){
                    for(int y = j; y < j+3 ; y++){
                        matrixA[x][y] = matrixA[x][y] == '1' ? '0' : '1';
                    }
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(matrixA[i][j] != matrixB[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }
}
