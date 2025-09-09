package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[T + 1][W + 1][3];

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][1];
                    if (num == 1) {
                        dp[i][j][1]++;
                    }
                    continue;
                }
                if (j % 2 == 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
                    if (num == 1) {
                        dp[i][j][1]++;
                    }
                } else {
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                    if (num == 2) {
                        dp[i][j][2]++;
                    }
                }
            }
        }

        int jadoo = 0;

        for (int i = 0; i <= W; i++) {
            if (jadoo < dp[T][i][i % 2 + 1]) {
                jadoo = dp[T][i][i % 2 + 1];
            }
        }
        System.out.print(jadoo);
    }
}
// G4 자두나무 DP
// 1. DP 상태 정의
// 기억해야되는 정보 는 시간과 움직인 횟수 현재 위치의 나무 번호이다
// 그래서 3차원으로 dp 상태를 정의하고 dp 상태의 값은 i 초일 때 j 번 움직여서 k 번 나무에 있을때 자두의 최대 개수이다
// 2. 바텀업 방식을 통해서 1초부터 T초까지 테이블을 채우며
// 현재 위치는 지금까지 총 몇번 움직였냐를 파악해서 움직임 횟수가 j가 0이면 1번도 안움직이고 1번나무인거고 홀수이면 2번 나무이다
// 3. 점화식
// dp 는 i-1 의 상태로부터 결정되기 때문에 현재상태는 가만히있다가 오거나 움직였거나 2가지 방법뿐이라서 2가지로 분기처리해서
// 더 큰값을 가졌을 때의 값으로 점화식을 만들어서 선택한다.
// 근데 만약에 num이랑 같으면 +1 해줘야된다.
// 4. 기저 값 j가 0일때 한번도 움직이지 않은 경우만 가능하고 원래 j가 0이면 이전값을 비교하는데 j-1이 안되기에
// 그냥 이전위치의 값만 가져와서 쓰고 num이랑 같으면 +1 해준다
// DP 테이블 다채우고나서 T초에 움직인 W마다 경우의수에서 최대값을 구한다.