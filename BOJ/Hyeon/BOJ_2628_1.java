package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2628_1 {
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ArrayList<Integer> rowCuts = new ArrayList<>();
        ArrayList<Integer> colCuts = new ArrayList<>();

        // 양 끝 조각을 넣어서 길이 측정
        rowCuts.add(0);
        rowCuts.add(R);

        colCuts.add(0);
        colCuts.add(C);

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            if (dir == 0) {
                rowCuts.add(line);
            } else {
                colCuts.add(line);
            }
        }

        Collections.sort(rowCuts);
        Collections.sort(colCuts);

        int max = getMaxGap(rowCuts) * getMaxGap(colCuts);

        System.out.println(max);
    }

    static int getMaxGap(ArrayList<Integer> list) {
        int maxGap = 0;

        for (int i = 1; i < list.size(); i++) {
            int gap = list.get(i) - list.get(i - 1);
            maxGap = Math.max(maxGap, gap);
        }
        return maxGap;
    }
}
// S5 종이자르기 수학
// 잘린 것중에서 가장 긴 세로와 가장 긴 가로의 곱을 반환.
// K log K 이다