package com.algo.java.hskim.greedy.book;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Book08 {
    /**
     * 04.만들 수 없는 금액(p314)
     * 같은 문제 3회 풀기
     */

    /**
     * 1회차 : 2023-07-09
     *
     * (참고)
     * N = 5, COIN = "3 2 1 1 9"
       - target 에 저장되는 값은 1부터 target 까지 모든 금액을 만들 수 있는 값, 상태.
       - 주어진 동전(3 2 1 1 9)에서 확인하려는 현재 동전이 target 보다 작아야 현재 동전으로 target 을 만들 수 있다.
        때문에 해당 조건이 만들 수 없는 금액의 break 조건이 된다.
      target        coin     result
         1      <    1       false
     (1+1=)2    <    1       false
     (2+1=)3    <    2       false
     (3+2=)5    <    3       false
     (5+3=)8    <    9       true
     *
     */
    public static int solution01(StringTokenizer st) {
        int target = 1;
        int count = st.countTokens();

        int[] moneyArr = new int[count];

        while(st.hasMoreTokens()) {
            int index = moneyArr.length - count;
            moneyArr[index] = Integer.parseInt(st.nextToken());
            count--;
        }

        Arrays.sort(moneyArr);

        for(int coin : moneyArr) {
            if(target < coin) {
                break;
            }
            else {
                target += coin;
            }
        }

        return target;
    }

    /**
     * 1회차 : 2023-07-02
     *
     * 5
     * 3 2 1 1 9
     *
     * 3
     * 3 5 7
     *
     * 1. 주어진 화폐 단위의 최소값, 최대값을 구한다.
     * 2. 1 ~ 최대값 이내에서 최소값이 1보다 클 경우 리턴.
     * 3. 1보다 큰 값이 없다면 주어진 화폐 단위들로 1 ~ 최대값까지 조합할 수 있는 단위를 확인한다.
     * 4. 만들어낼 수 없는 값이 있다면 해당 값이 금액 중 최솟값.
     */
    public static int solution01_fail(StringTokenizer st) {
        int result = 0;
        int count = st.countTokens();

        int[] moneyArr = new int[count];

        //0.문자열 화폐 단위 -> 숫자 화폐 단위
        while(st.hasMoreTokens()) {
            int index = moneyArr.length - count;
            moneyArr[index] = Integer.parseInt(st.nextToken());
            count--;
        }

        //1. 주어진 화폐 단위의 최소값, 최대값을 구한다.
        Arrays.sort(moneyArr);

        int min = moneyArr[0];
        int max = moneyArr[moneyArr.length-1];

        //2. 1 ~ 최대값 이내에서 최소값이 1보다 클 경우 리턴
        if(min > 1) {
            return 1;
        }

        //3. 1보다 큰 값이 없다면 주어진 화폐 단위들로 1 ~ 최대값까지 조합할 수 있는 단위를 확인한다.
        ArrayList<Integer> numArr = new ArrayList<>();
        for(int i = 0; i < max; i++) {
            numArr.add((i+1));
        }

        for(int money : moneyArr) {
            for(int i = 0; i < numArr.size(); i++) {
                int num = numArr.get(i);

                if(money == num) {
                    numArr.remove(i);
                }
            }
        }

        for(int i = 0; i < numArr.size(); i++) {
            int num = numArr.get(i);
            int sum = moneyArr[0];
            boolean isMoney = false;

            for(int j = 0; j < moneyArr.length; j++) {
                int sub = num - sum;

                for(int k = j+1; k < moneyArr.length; k++) {
                    if(moneyArr[k] == sub) {
                        isMoney = true;
                    }
                }

                if(!isMoney && (j+1) < moneyArr.length) {
                    sum += moneyArr[j+1];
                }
            }

            if(!isMoney) {
                result = num;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();
        bw.write(String.valueOf(solution01(st)));
        bw.flush();
        bw.close();
    }
}
