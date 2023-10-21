package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 과제
 */
public class B13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Homework> homeworkList = new ArrayList<>();
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            homeworkList.add(new Homework(day, score));
            maxDay = Math.max(maxDay, day);
        }

        int result = 0;
        for (int i = maxDay; i >= 1; i--) {
            Homework temp = new Homework(0, 0);

            for (Homework homework : homeworkList) {
                if (homework.day >= i) {
                    if (temp.score < homework.score) {
                        temp = homework;
                    }
                }
            }

            result += temp.score;
            homeworkList.remove(temp);
        }

        System.out.println(result);
    }
}

class Homework {
    int day;
    int score;

    Homework(int day, int score) {
        this.day = day;
        this.score = score;
    }
}
