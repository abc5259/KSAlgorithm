package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;

        sum += (N * M) * 2;

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp += map[i][0];
            for (int j = 1; j < M; j++) {
                if (map[i][j - 1] < map[i][j]) {
                    tmp += map[i][j] - map[i][j - 1];
                }
            }
        }
        sum += tmp * 2;

        tmp = 0;
        for (int i = 0; i < M; i++) {
            tmp += map[0][i];
            for (int j = 1; j < N; j++) {
                if (map[j - 1][i] < map[j][i]) {
                    tmp += map[j][i] - map[j - 1][i];
                }
            }
        }
        sum += tmp * 2;

        System.out.println(sum);
    }
}
// S2 겉넓이 구하기 수학
// 25분
// 그냥 풀었다
// 겉넓이 구한다고 이전 값과 비교해서 누적해서 더하고 아래위 와 사이의 4개의 면은 2쌍으로 해서 연산