package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 수 묶기
 */
public class B01744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> positiveNumbers = new ArrayList<>(); // 양수
        List<Integer> negativeNumbers = new ArrayList<>(); // 음수
        int oneCount = 0;
        int zeroCount = 0;

        int result = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 1) {
                oneCount++;
            } else if (temp == 0) {
                zeroCount++;
            } else if (temp < 0) {
                negativeNumbers.add(temp);
            } else {
                positiveNumbers.add(temp);
            }
        }

        /**
         * 1보다 큰 양수는 큰 수부터 짝지어 곱하기 처리
         */
        int positiveIndex = 0;
        Collections.sort(positiveNumbers, Collections.reverseOrder());
        while (positiveIndex + 1 <= positiveNumbers.size() - 1) {
            int positiveNumber1 = positiveNumbers.get(positiveIndex);
            int positiveNumber2 = positiveNumbers.get(positiveIndex + 1);
            result += (positiveNumber1 * positiveNumber2);
            positiveIndex += 2;
        }

        /**
         * 짝짓지 못한 남은 양수는 더하기 처리
         */
        if (positiveIndex == positiveNumbers.size() - 1) {
            result += positiveNumbers.get(positiveIndex);
        }

        /**
         * 1보다 작은 음수는 작은 수부터 짝지어 곱해 양수로 변환
         */
        int negativeIndex = 0;
        Collections.sort(negativeNumbers);
        while (negativeIndex + 1 <= negativeNumbers.size() - 1) {
            int negativeNumber1 = negativeNumbers.get(negativeIndex);
            int negativeNumber2 = negativeNumbers.get(negativeIndex + 1);
            result += (negativeNumber1 * negativeNumber2);
            negativeIndex += 2;
        }

        /**
         * 짝짓지 못한 음수는 더하기 처리
         */
        if (zeroCount == 0) {
            if (negativeIndex == negativeNumbers.size() - 1) {
                result += negativeNumbers.get(negativeIndex);
            }
        }

        /**
         * 1은 그대로 더하기 처리
         */
        result += oneCount;

        System.out.println(result);
    }
}
