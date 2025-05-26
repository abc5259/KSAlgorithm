package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] mul = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int p = 0; p < K; p++) {
                    mul[i][p] += A[i][j] * B[j][p];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : mul) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

// S5 행렬 곱셈 수학
// 행렬 제곱 풀기 위해서 곱셈부터해서 행렬에 대한 연산 방법을 알게 되었다.
// NM, 행의 원소 * MK 열의 원소를 곱해서 새로운 행렬을 만든다.