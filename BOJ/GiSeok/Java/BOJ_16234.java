/**
 * 16234 - 인구 이동 [성공|01:19:09]
 * 골드4, BFS, 시도2
 * 
 * 크게 보면 '연결요소 구하기' 문제이다.
 * 인구 이동의 최대 일 수가 2000
 * 도시 갯수는 최대 N*N
 * 하루마다 모든 정점에 대해 BFS를 통해 연합을 찾고 해당 연합의 값을 모두 바꾼다.
 * 그럼, 시간복잡도 = 2000 * (2500 * 2500) = 약 250억인데
 * 조건에 따라 2000이 2000일 전부가 아닐 수도 있다. 또한, 연합이 아니라면 N^2 시간 복잡도가 적용되지 않는다.
 * 그래서 통과한 로직인 것 같다.
 * O(k * N^4)
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_16234 {
    // 시간제한 2초
    // N*N 크기의 땅
    // 각각의 땅에 나라가 1개씩 존재 r행 c열에 있는 나라에는 A[r][c]명이 살고있음
    // 인구 이동은 하루 동안 다음과 같이 진행, 더 이상 아래 방법으로 인구 이동 없을때까지 지속
    // 1. 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하면 두 나라 사이 국경선을 하루동안 엶
    // 2. 위의 조건에 의해 열려야하는 국경선이 모두 열렸다면 인구이동
    // 3. 국경선이 열려 인접한 칸만 이동할 수 있으면, 그 나라를 하루 동안 연합
    // 4. 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
    // 5. 연합을 해체하고 모든 국경선을 닫음.

    // 각 나라 인구수가 주어지면 며칠 동안 인구이동?
    // 1 <= N <= 50
    // 1 <= L <= R <= 100

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] A;
    static int[][] union;
    static int N, L, R;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int d = 0; d <= 2000; d++) {
            union = new int[N][N];
            ArrayDeque<Pair> q = new ArrayDeque<>();
            int uni = 1;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (union[y][x] == 0) {
                        q.add(new Pair(y, x));
                        union[y][x] = uni;
                        int people = A[y][x];
                        int cnt = 1;

                        while (!q.isEmpty()) {
                            Pair p = q.poll();

                            for (int i = 0; i < 4; i++) {
                                int ny = p.y + dy[i];
                                int nx = p.x + dx[i];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                                if (union[ny][nx] > 0) continue;
                                if (Math.abs(A[p.y][p.x] - A[ny][nx]) < L || Math.abs(A[p.y][p.x] - A[ny][nx]) > R) continue;

                                q.add(new Pair(ny, nx));
                                union[ny][nx] = union[p.y][p.x];
                                people += A[ny][nx];
                                cnt++;
                            }
                        }

                        if (cnt != 1) {
                            int up = people / cnt;

                            for (int i = 0; i < N; i++) {
                                for (int j = 0; j < N; j++) {
                                    if (union[i][j] == uni) A[i][j] = up;
                                }
                            }
                        }

                        uni++;
                    }
                }
            }

            if (uni == (N*N) + 1) { ret = d; break; }
        }

        System.out.println(ret);
    }
}
