package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = board[i][j];
                if (tmp + i < N && tmp != 0) {
                    dp[i + tmp][j] += dp[i][j];
                }
                if (tmp + j < N && tmp != 0) {
                    dp[i][j + tmp] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}

// S1 점프 DP
// 아 메모이제이션을 활용해야하는데 기존의 격자를 어떻게 다뤄야할지 몰랐다.
// 근데 힌트를 보고 누적합을 떠올렸고 격자 배열을 순서대로 대입시켰다
// 해당 요구사항은 그냥 값을 인덱스에 더해가면서 대입하는건데 최종적으로는 N-1 N-1 자리에
// 오는게 몇개냐 이건데 거기까지가는 숫자들의 개수를 더하려면
// 시작값을 0으로 잡고 이를 인덱스화 해서 연산해서 N-1N-1까지 도착하게 했다
// 이때 문제는 tmp 가 0이니까 계속 본인스스로 2번 더해버려서 3이 나와야될게
// 12가 나와버렸다 너무 어려웟다
// trouble shooting
// 일단 0이 아닐 때를 제외해주고 long 타입 확인해주고 1로 시작해서 개수 확인한다.