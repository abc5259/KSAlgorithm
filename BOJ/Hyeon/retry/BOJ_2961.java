package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
    static int[][] tastes;
    static boolean[] sel;

    static int min;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tastes = new int[N][2];// 신맛 쓴맛
        sel = new boolean[N]; //각 원소가 선택되었는지 여부

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }

        subSet(0, 1, 0);
        System.out.println(min);
    }

    static void subSet(int idx, int sour, int bitter) {
        if (N == idx) {
            int allFalse = 0;
            for (boolean b : sel) {
                if (b)
                    continue;
                allFalse++;
            }
            if (allFalse == N) {
                return;
            }
            min = Math.min(min, Math.abs(sour - bitter));
            return;
        }
        sel[idx] = true;
        subSet(idx + 1, tastes[idx][0] * sour, tastes[idx][1] + bitter);
        sel[idx] = false;
        subSet(idx + 1, sour, bitter);
    }
}
// S2 도영이가 만든 맛있는 음식
// 부분집합 문제
// 재귀활용
// retry