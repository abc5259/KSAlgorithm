package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int cnt = 0;
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visit[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            if (cnt == 0) {
                System.out.println(0);
                return;
            }
            year++;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                continue;
            }
            if (map[ny][nx] <= 0) {
                map[y][x]--;
            } else {
                dfs(ny, nx);
            }
        }
    }
}
// G4 빙산 DFS
// 40분
// 일단 개 뻘짓했다 프로그래머스가 익숙해져서 입력값의 배열을 초기화를 안해줬다.
// 그리고 탈출 조건인 return 0도 안썼다
// 나머지로는 모든 로직이 맞았다
// 일단 N과 M은 300까지 가능하고 빙산의 개수가 2개이상이면 탈출하는데 이는
// 섬의 개수 단지개수와 같은 맥락이다 이를통해 완전 탐색으로 거쳐서 최단거리를 구하는 것은
// 제자리에서 퍼져나가서 플러드필 처럼 동시에 줄어들게 하는 BFS 와 dfs 의 실행횟수의 합을 비교하는 방식 2가지가 있다
// 나는 DFS 연습겸 DFS 로 풀었다.