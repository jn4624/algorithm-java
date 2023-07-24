package com.algo.java.hskim.greedy.web;

import java.util.Scanner;

/**
 * 리모컨
 * https://codeup.kr/problem.php?id=3120
 */
public class C03120 {
    /**
     * 2회차 : 2023-07-23
     * 다시풀기
     */
    public static int solution02(int currVal, int targetVal) {
        int count = Math.abs((currVal-targetVal)) / 10;
        int absolute = Math.abs((currVal-targetVal)) % 10;

        if(absolute == 1 || absolute == 5) {
            count += 1;
        }
        else if(absolute == 2 || absolute == 4 || absolute == 6 || absolute == 9) {
            count += 2;
        }
        else if(absolute == 3 || absolute == 7 || absolute == 8) {
            count += 3;
        }

        return count;
    }

    /**
     * 1회차 : 2023-07-19
     * 실패, 시간초과
     시간초과 : 제출한 프로그램이 특정 입력에 대해 제한된 시간내에 끝나지 않은 경우를 뜻합니다.
     1. 무한 루프가 있지는 않나요? (예: while(1){ .. } )
     2. 중복으로 계산하는 부분이 있다면 배열을 활용하여 값을 저장하십시오.(메모이제이션 기법)
     3. O(N^2) 알고리즘(중첩 for)을 설계하셨다면 더 효율적인 O(N)(단일 for)이나 O(NlgN) 알고리즘으로 다시 설계하시기 바랍니다.
     */
    public static int solution01(int currVal, int targetVal) {
        int count = 0;
        int total = currVal;

        while(total != targetVal) {
            if((total+10) <= targetVal) {
                total += 10;
                count++;
            }
            else if((total+5) <= targetVal) {
                total += 5;
                count++;
            }
            else if((total+1) <= targetVal) {
                total += 1;
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currVal = sc.nextInt();
        int targetVal = sc.nextInt();

        System.out.println("currVal: " + currVal);
        System.out.println("targetVal: " + targetVal);
        System.out.println("result: " + solution01(currVal, targetVal));
        System.out.println("result: " + solution02(currVal, targetVal));
    }
}