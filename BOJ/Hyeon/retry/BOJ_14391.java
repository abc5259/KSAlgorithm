package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                square[i][j] = c[j] - '0';
            }
        }

        int total = N * M;

        int max = 0;

        for (int mask = 0; mask < (1 << total); mask++) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int curr = 0;
                for (int j = 0; j < M; j++) {
                    int idx = i * M + j;

                    boolean isHorizontal = ((mask >> idx) & 1) == 0;

                    if (isHorizontal) {
                        curr = curr * 10 + square[i][j];
                    } else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }

            for (int j = 0; j < M; j++) {
                int curr = 0;
                for (int i = 0; i < N; i++) {
                    int idx = i * M + j;
                    boolean isVertical = ((mask >> idx) & 1) == 1;
                    if (isVertical) {
                        curr = curr * 10 + square[i][j];
                    } else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}

// G3 종이 조각 비트마스크 , 브루트포스
// 3시간 걸려도 못풀겠다.