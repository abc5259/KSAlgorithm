package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int size = Math.min(N, M);

        int res = 1;

        for (int s = 2; s <= size; s++) {
            for (int i = 0; i <= N - s; i++) {
                for (int j = 0; j <= M - s; j++) {
                    int point = map[i][j];
                    if ((point == map[i][j + s - 1]) &&
                            (point == map[i + s - 1][j]) &&
                            (point == map[i + s - 1][j + s - 1])) {
                        res = s * s;
                    }
                }
            }
        }
        System.out.print(res);
    }
}
// S3 숫자 정사각형 완전탐색
// 그냥 풀어서 비교했다.