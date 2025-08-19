package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int q = i - 1; q < x; q++) {
                for (int p = j - 1; p < y; p++) {
                    sum += arr[q][p];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}

// S5 2차원 배열의 합 구현
// 그냥 풀었다. 완전 탐색으로 접근