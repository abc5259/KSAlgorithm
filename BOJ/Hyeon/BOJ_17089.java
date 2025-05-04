package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int res = Integer.MAX_VALUE;

        boolean[][] friends = new boolean[N][N];
        int[] cnt = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            friends[A][B] = true;
            friends[B][A] = true;
            cnt[A]++;
            cnt[B]++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (friends[i][j]) {
                    for (int q = j + 1; q < N; q++) {
                        if (friends[i][q] && friends[j][q]) {
                            int sum = cnt[i] + cnt[j] + cnt[q] - 6;
                            res = Math.min(res, sum);
                        }
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(res);
        }
    }
}

// G5 세 친구 브루트포스, 그래프
// 무방향 그래프로 했다.
// 일단
