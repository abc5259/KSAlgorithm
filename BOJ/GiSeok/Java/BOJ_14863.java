/**
 * 14863 - G4 서울에서 경산까지 [O|00:34:31]
 * DP, 시도4
 */
// 3 <= N <= 100, 0 < K <= 100,000
// 각 도시마다 2개의 경로가 존재하므로 시간이 넉넉할 때 모든 경우의 수는 2^100.
// 서브태스크 1은 N <= 20이므로 약 100만에 해결 가능 -> 완탐이 가능하다.
// 서브태스크 2는 N <= 100. 완탐이 불가. 다른 방법으로 해결해야 함. DP?
// n번 도시에서 남은 시간에 따라 dp를 구성해 최댓값을 넣는다?
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_14863 {

    static int n, k;
    static int[][][] city;
    static int[][] dp;

    static int go(int here, int time) {

        if (time > k) return -1987654321;
        if (here >= n) return 0;
        if (dp[here][time] != 0) return dp[here][time];

        dp[here][time] = go(here + 1, time + city[here][0][0]) + city[here][0][1];
        dp[here][time] = Math.max(dp[here][time], go(here + 1, time + city[here][1][0]) + city[here][1][1]);

        return dp[here][time];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        city = new int[n][2][2];
        // [n][0][0] = 도보 time, [n][0][1] = 도보 모금액
        // [n][1][0] = 자전거 time, [n][1][1] = 자전거 모금액

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                city[i][j][0] = Integer.parseInt(st.nextToken());
                city[i][j][1] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][100001];
        bw.write(go(0, 0) + "");
        bw.flush(); bw.close();
    }

}
