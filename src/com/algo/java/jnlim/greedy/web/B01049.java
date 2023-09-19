package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 기타줄
 */
public class B01049 {
    public static final int packageGuitarStringCount = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int guitarStringBrokenCount = Integer.parseInt(st.nextToken());
        int guitarStringBrandCount = Integer.parseInt(st.nextToken());

        int[] packagePrices = new int[guitarStringBrandCount];
        int[] singlePrices = new int[guitarStringBrandCount];

        for (int i=0; i<guitarStringBrandCount; i++) {
            st = new StringTokenizer(br.readLine());
            packagePrices[i] = Integer.parseInt(st.nextToken());
            singlePrices[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 저렴한 패키지 가격
        int minPackagePrice = Arrays.stream(packagePrices).min().getAsInt();
        // 가장 저렴한 낱개 가격
        int minSinglePrice = Arrays.stream(singlePrices).min().getAsInt();

        int result = Integer.MAX_VALUE;

        // 가장 저렴한 패키지 구매 VS 가장 싼 낱개 구매 VS (가장 싼 패키지 구매 + 낱개 구매)
        result = Math.min(((guitarStringBrokenCount / packageGuitarStringCount) + 1) * minPackagePrice
                , guitarStringBrokenCount * minSinglePrice);
        result = Math.min(result, ((guitarStringBrokenCount/packageGuitarStringCount) * minPackagePrice) + ((guitarStringBrokenCount%packageGuitarStringCount) * minSinglePrice));

        System.out.println(result);
    }
}
