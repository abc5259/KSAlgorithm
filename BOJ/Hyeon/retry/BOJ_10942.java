package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

//        // 길이가 1일때 팰린드롬
//        for (int i = 1; i <= N; i++) {
//            dp[i][i] = true;
//        }
//
//        // 길이가 2일 때
//        for (int i = 1; i < N; i++) {
//            if (arr[i] == arr[i + 1]) {
//                dp[i][i + 1] = true;
//            }
//        }
//
//        // 길이가 3이상이면
//        for (int i = 3; i <= N; i++) {
//            for (int j = 1; j <= N - i + 1; j++) {
//                if (arr[i] == arr[i + j - 1] && dp[i + 1][j - 1]) {
//                    dp[i][j] = true;
//                }
//            }
//        }

        for (int i = N; i > 0; i--) {
            for (int j = i; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (arr[i] == arr[j]) {
                    if (Math.abs(i - j) == 1 || (dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S][E] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
// G4 팰린드롬? DP
// 팰린드롬과 DP 에 대해 좋은 문
// 시간 복잡도 고민 : N이 100만이라 ON^2 는 불가능
// 계산결과를 미리 저장해두면 즉시 답할 수 있으니 DP를 설정
// DP 상태 정의
// S번째 수부터 E번째 구간이 팰린드롬이면 true 아니면 false를 주기 위해 2차원 배열로 정의한다.
// 기억해야되는 부분이 S와 E 인덱스 였던 것 그럼 O1
// 점화식 1.시작점이랑 끝점이 같으면 즉 길이가 1이면 팰린드롬이므로 true 해버리고
// 2. 양끝의 숫자가 같으면 팰린드롬의심하고 그 사이에 숫자가 팰린드롬이여야 ㅇㅋ인데 만약에
// 2자리 숫자였으면 2자리다 팰린드롬이니까 ㅇㅋ이고 아니면 i+1부터 j-1 까지 자리가 팰린드롬이여야만
// 팰린드롬이 된다.  근데 절댓값은 걍 2자리고 3자리이상이 dp 이다.