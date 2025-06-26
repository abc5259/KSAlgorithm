package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {
    static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][3];
        int min = MAX;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = rgb[1][j];
                } else {
                    dp[1][j] = MAX;
                }
            }

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + rgb[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + rgb[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + rgb[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    min = Math.min(min, dp[N][j]);
                }
            }
        }
        System.out.println(min);
    }
}

// G4 RGB 거리 2 DP
// 일단 색별로 반복해서 한다. 그리고 처음의 색을 저장해둬야 나중에 맨 끝에서 비교해서 최소값을 구할 수 있다.
// 일단 R 부터 시작한다면 3개짜리 반복문이랑 3개중에 1개만 값을 dp에 저장해서 그거로 시작하기위해 이중 반복문을 사용한다/
// 나머지의 색상은 MAX 값을 대입해서 범위보다 크게 한다.
// 그리고 2부터 N까지 배열을 다 dp 로 연산해서 나랑 다른 인덱스의 2수의 최소값 + 기존 RGB 값 해서
// dp 배엻에다가 이전 dp 비교 + 현재 rgb 값으로 반복문을 돌린다
// 마지막으로는 3개의 RGB 중에서 i 가 현재 내가 고른 색이니까 i랑 다른 인덱스를 가진
// 색상들의 최소값을 구해서 리턴한다.