package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};

    static int N;
    static int[][] pipe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pipe = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pipe[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    static int cnt;

    static void dfs(int y, int x, int dir) {
        if (y == N - 1 && x == N - 1) {
            cnt++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) {
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= N || nx >= N || pipe[ny][nx] != 0) {
                continue;
            }
            if (i == 2 && (pipe[ny - 1][nx] != 0 || pipe[ny][nx - 1] != 0)) {
                continue;
            }
            dfs(ny, nx, i);
        }
    }
}

// G5 파이프 옮기기 1 DFS
// 일단 방식은 이해했는데 구현이 어려웠다. 조건문 나누는게 빠듯
// trouble shooting
// ny 와 nx 와 같은 인덱스 조건을 먼저검사해야한다.
// 이를 나중에 할 경우 indexoutofbound 에러발생

// dfs로 끝까지 갈 수 있는 것들확인하고 누적합으로 결과 도출
// 델타로 꾸려서 dfs 동작하는데 대각선일 경우 조건문을 통과해야 대각선 dfs가 동작하고 아니면 continue
// 가로 세로도 마찬가지 기저조건으로 탐색