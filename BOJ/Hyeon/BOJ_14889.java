package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;

        comb(0, 0);
        System.out.println(min);
    }

    static void comb(int depth, int start) {
        if (depth == N / 2) {
            cal();
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            comb(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
}
// S1 스타트와 링크 백트래킹 조합
// 25분
// 걍 풀었다.