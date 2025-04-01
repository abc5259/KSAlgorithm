package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][M];

        int max = 0;
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                dp[i][j] = str.charAt(j) - '0';
                if (dp[i][j] == 1) max = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}

// G4 가장 큰 정사각형 DP 개쉬웠음
// 근데 주의해야할 점 반례
// trouble shooting
// 메모이제이션을 활용하여 누적합으로 dp에 대입하는데 이때 최고값을 구할 때
// 초기값 설정이 중요하다 아래 최고값 을 찾는 반복문은 i=1, j=1부터 시작하기 떄문에 행열이 1 1 , 1 5등 1로 주어졌을 경우
// max가 비교값 갱신이 안돼서 최고값을 구하지 못하는 경우가 발생한다
//-----------------
// 1 5
// 00001
// -> 초기값 0으로 설정 시 0출력 옳게된 답 1
