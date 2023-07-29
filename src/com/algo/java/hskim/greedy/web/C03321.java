package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 최고의 피자
 * https://codeup.kr/problem.php?id=3321
 */
public class C03321 {

    /**
     * 1회차 : 2023-07-23
     * 다시풀기
     */
    public static int solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int price_dough = Integer.parseInt(st.nextToken());
        int price_toping = Integer.parseInt(st.nextToken());

        int cal_dough = Integer.parseInt(br.readLine());
        ArrayList<Integer> cal_toping = new ArrayList<>();

        //토핑 칼로리
        while(N > 0) {
            cal_toping.add(Integer.parseInt(br.readLine()));
            N--;
        }

        Collections.sort(cal_toping, Collections.reverseOrder());

        int bestCal = cal_dough;
        int bestPrice = price_dough;
        double bestPizza = bestCal / bestPrice;
        double tempPizza = 0;

        for(int calorie : cal_toping) {
            tempPizza = (bestCal + calorie) / (bestPrice + price_toping);

            if(bestPizza < tempPizza) {
                bestCal += calorie;
                bestPrice += price_toping;
                bestPizza = tempPizza;
            }
            else {
                bestCal += calorie;
                bestPrice += price_toping;
            }
        }

        return (int) Math.round(bestPizza);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution01());
    }
}