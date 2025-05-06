package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layer = Math.min(N, M) / 2;

        for (int r = 0; r < R; r++) {
            for (int i = 0; i < layer; i++) {
                int tmp = arr[i][i];

                // 상단
                for (int col = i + 1; col < M - i; col++) {
                    arr[i][col - 1] = arr[i][col];
                }

                // 우측
                for (int row = i + 1; row < N - i; row++) {
                    arr[row - 1][M - 1 - i] = arr[row][M - 1 - i];
                }

                // 하단
                for (int col = M - 2 - i; col >= i; col--) {
                    arr[N - 1 - i][col + 1] = arr[N - 1 - i][col];
                }

                // 좌측
                for (int row = N - 2 - i; row > i; row--) {
                    arr[row + 1][i] = arr[row][i];
                }

                arr[i + 1][i] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
// G5 배열 돌리기 1 회전, 브루트포스
// 그냥 회전의 횟수가 1000이고 layer 또한 최대 150이기에 시간복잡도 측에서 횟수별로 각 계층을 돌리면된다.
// rotate 의 기본으로 가장 처음값을 저장해두고 값들을 이동시킨다음에 마지막에 저장해뒀던 임시값을 넣어준다.
// 일단 상단, 우측, 하단, 좌측별로 나눠서 동작하였으며
// 인덱스별로 통제하면된다.