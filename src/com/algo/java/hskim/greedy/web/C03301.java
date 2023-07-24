package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C03301 {
    /**
     * 거스름돈
     * https://codeup.kr/problem.php?id=3301
     *
     * 입력 : 거스름돈 n이 입력된다. ( n은10이상의  int 범위 )
     * 54520
     *
     * 출력 : 최소 거스름돈의 개수를 출력한다.
     * 8
     */

    /**
     어떤 가게의 욕심쟁이 점원은 거스름돈을 나눠줄때 거스름돈의 개수를 적게해서 주고자 한다.

     거스름돈을 입력 받아 점원이 줄 수 있는 최소 거스름돈의 개수를 출력하시오.

     예를 들어 54520원인 경우,

     거스름돈으로 50000원권 1장, 1000원권 4장, 500원 1개, 10원 2개 해서 총 8개이다.

     (※ 현재 우리나라가 사용하고 있는 화폐를 사용한다. 10원 50원 100원 500원 1,000원 5,000원 10,000원 50,000원)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int money = Integer.parseInt(br.readLine());
        int change = 0;
        float temp = 0;

        for(int unit : moneyUnit) {
            if(money != 0) {
                temp = money / unit;

                if(temp >= 1) { //money보다 나누려는 값이 클 경우 몫은 1보다 작다
                    change += money / unit;
                    money %= unit;
                }
            }
        }

        System.out.println("change: " + change);
    }
}