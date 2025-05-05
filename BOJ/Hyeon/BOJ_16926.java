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
        int layers = Math.min(N, M) / 2;
        for (int r = 0; r < R; r++) {
            for (int layer = 0; layer < layers; layer++) {
                int top = layer, left = layer;
                int bottom = N - 1 - layer, right = M - 1 - layer;

                int tmp = arr[top][left];

                for (int j = left; j < right; j++) {
                    arr[top][j] = arr[top][j + 1];
                }

                for (int i = top; i < bottom; i++) {
                    arr[i][right] = arr[i + 1][right];
                }

                for (int j = right; j > left; j--) {
                    arr[bottom][j] = arr[bottom][j - 1];
                }

                for (int i = bottom; i > top; i--) {
                    arr[i][left] = arr[i - 1][left];
                }

                arr[top + 1][left] = tmp;
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