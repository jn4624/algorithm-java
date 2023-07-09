package com.algo.java.hskim.greedy.book;

import java.io.*;

public class Book07 {
    /**
     * 03.문자열 뒤집기(p313)
     * 같은 문제 3회 풀기
     */

    /**
     * 1회차 : 2023-07-02
     */
    public static int solution01(String str) {
        int result = 0;

        int zero = 0;
        int one = 0;
        char ch = str.charAt(0);

        if(ch == '0') zero++;
        else if(ch == '1') one++;

        for(int i = 1; i < str.length(); i++) {
            char _ch = str.charAt(i);

            if(ch != _ch) {
                if(ch == '0') zero++;
                else if(ch == '1') one++;

                ch = _ch;
            }
        }

        System.out.println("zero: " + zero);
        System.out.println("one: " + one);

        return zero > one ? one : zero;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = br.readLine();

        br.close();
        bw.write(String.valueOf(solution01(numStr)));
        bw.flush();
        bw.close();
    }
}
