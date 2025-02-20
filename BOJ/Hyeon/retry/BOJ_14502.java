package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int N, M;
    static int[][] map; // 주어진 연구실
    static int[][] tmpMap; // 연구실에서 바이러스가 확산됐을 때
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    // 델타
    static int res;

    // 최대값 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입출력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmpMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 벽을 만든다.
        makeWall(0);
        System.out.println(res);
    }

    static void makeWall(int depth) {
        // 2. 벽을 만드는데 dfs방식으로 3개까지 벽을 만들 수 있으니까 기저조건 == 3으로 걸어서
        // 반복하고 3이되면 바이러스를 생성하게끔 한다.
        // 백트래킹을 통해서 0인 빈공간을 1로 만들고 다음 벽을 하러갔다가 다하고 오면 그 벽들을 다시
        // 0으로 허물어준다.

        if (depth == 3) {
            makeVirus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void makeVirus() {
        // 3. 바이러스 만들기 벽을 다 만들고 났으면 그때 바이러스를 만들어서 계산해야된다.
        // 일단 새롭게 만든 tmp임시 격자에 복사해준다음
        //  System.arraycopy 를 사용
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }
        // 4. 바이러스가 있는 곳에서 dfs로 끝까지 퍼뜨린다.

        // 6. 최대 안전 구역의 값을 비교해서 구한다음 이를 정적 변수에 저장해둔다.
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        res = Math.max(res, cnt);
    }

    static void dfs(int y, int x) {
        // 5. 바이러스가 퍼지는 것은 델타로 퍼져서 이를
        // 방문 여부 확인을 해주기 위해 2로 바빈공간을 바이러스로 바꿨다. 그리고
        // 재귀를 통해 dfs 를 끝까지 하고나서
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && nx < M && ny < N && tmpMap[ny][nx] == 0) {
                tmpMap[ny][nx] = 2;
                dfs(ny, nx);
            }
        }
    }
}

// G4 연구실 DFS , 백트래킹
// 일단 메소드를 펼치는 것을 생각해라
// 의사코드
// 1. 벽을 만들기 => dfs 백트래킹으로 벽의 개수를 3개까지 계산해서 기저조건으로 받고
// 3개가 만들어지면 바이러스를 퍼뜨리러 간다
// 2. 바이러스를 퍼뜨리러가면 임시 격자에 다가 2를 탐색해서 이를 dfs 연산해주면된다.
// 3. dfs 를 끝까지하고 ==0을 =2로 방문 여부도 확인해주고 복귀하면
// 4. 안전지대의 개수를 반환한다.
// 이렇게 순서대로 시뮬레이션 화 해서 구하면된다.


