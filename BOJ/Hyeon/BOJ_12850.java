package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12850 {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());

        long[][] baseMatrix = {
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0}
        };

        long[][] ansMatrix = new long[8][8];
        for (int i = 0; i < 8; i++) {
            ansMatrix[i][i] = 1;
        }

        while (D > 0) {
            if (D % 2 == 1) {
                ansMatrix = multiply(ansMatrix, baseMatrix);
            }
            baseMatrix = multiply(baseMatrix, baseMatrix);
            D /= 2;
        }

        System.out.println(ansMatrix[0][0]);
    }

    static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] result = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    result[i][j] = (result[i][j] + m1[i][k] * m2[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
// P5 본대 산책2 행렬 거듭제곱
// 40분
// D가 최대 10억이므로 일반적인 BFS나 DP로는 무조건 시간 초과 발생. O(log D) 해야되는데
// 인접 행렬의 수학적 성질인 인접 행렬을 N번 거듭제곱한 행렬의 [i][j]는 i에서 j로 N번 만에 가는 경로의 수 이용
// 건물이 8개이므로 8x8 베이스 인접 행렬을 만들고, 분할 정복을 이용해 D 거듭제곱을 수행.
// D를 절반씩 나누어 홀수일 때는 정답 행렬에 베이스 행렬을 곱하고, 짝수일 때는 베이스 행렬 스스로를 곱해 크기를 불려 나감 (10억 번 탐색 -> 30번 연산)
// 연산 중 오버플로우를 막기 위해 행렬 곱셈 3중 for문 내부에서 즉시 MOD(1,000,000,007) 연산을 수행하여 데이터 정합성 유지.