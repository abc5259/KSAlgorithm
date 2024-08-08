/**
 * 14889 - 스타트와 링크 [성공|00:43:09]
 * 실버1, 브루트포스, 시도1
 * 
 * 완전탐색을 진행해도 20C10 경우의 수에만 (N/2)^2 + (N/2)^2를 수행한다.
 * 그래서 전체 시간복잡도는 20C10 * ((20/2)^2 + (20/2)^2) = 3700만.
 * 1억을 1초로 잡으면 충분히 가능한 시간이다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14889 {
    // 시간제한 2초, 메모리제한 512mb
    // 축구를 위해 모인 사람 N명, N은 짝수

    static int N;
    static int[][] skils;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        skils = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                skils[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 0; n < (1 << N); n++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) if ((n & (1 << i)) >= 1) cnt++;

            if (cnt != (N/2)) continue;

            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if ((n & (1 << i)) >= 1) team1.add(i);
                else team2.add(i);
            }

            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    if (i == j) continue;
                    sum1 += skils[team1.get(i)][team1.get(j)];
                    sum2 += skils[team2.get(i)][team2.get(j)];
                }
            }

            ret = Math.min(ret, Math.abs(sum1 - sum2));
        }

        System.out.println(ret);
    }
}
