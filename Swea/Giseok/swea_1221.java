/**
 * 1221. [S/W 문제해결 기본] 5일차 - GNS (D3|구현) [O|00:12:22]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1221 {

    static Map<String, Integer> stringIntegerMap = new HashMap<>();
    static String[] integerStringMap = new String[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ts = Integer.parseInt(st.nextToken().substring(1));
            int length = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                arr.add(stringIntegerMap.get(st.nextToken()));
            }
            arr.sort(Comparator.naturalOrder());

            StringBuilder sb = new StringBuilder();
            for (int n : arr) {
                sb.append(integerStringMap[n]).append(" ");
            }

            System.out.println("#" + ts);
            System.out.println(sb);
        }
    }

    private static void init() {
        stringIntegerMap.put("ZRO", 0);
        stringIntegerMap.put("ONE", 1);
        stringIntegerMap.put("TWO", 2);
        stringIntegerMap.put("THR", 3);
        stringIntegerMap.put("FOR", 4);
        stringIntegerMap.put("FIV", 5);
        stringIntegerMap.put("SIX", 6);
        stringIntegerMap.put("SVN", 7);
        stringIntegerMap.put("EGT", 8);
        stringIntegerMap.put("NIN", 9);
        integerStringMap[0] = "ZRO";
        integerStringMap[1] = "ONE";
        integerStringMap[2] = "TWO";
        integerStringMap[3] = "THR";
        integerStringMap[4] = "FOR";
        integerStringMap[5] = "FIV";
        integerStringMap[6] = "SIX";
        integerStringMap[7] = "SVN";
        integerStringMap[8] = "EGT";
        integerStringMap[9] = "NIN";
    }

}