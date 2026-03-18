package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17484 {
    static int N, M;
    static int[][] map;

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

        for (int i = 0; i < M; i++) {
            dfs(0, i, map[0][i], -1);
        }

        System.out.println(cost);
    }

    static int cost = 600;
    static int[] dx = {-1, 0, 1};

    static void dfs(int y, int x, int sum, int dir) {
        if (y == N - 1) {
            cost = Math.min(cost, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == dir) {
                continue;
            }
            int ny = y + 1;
            int nx = x + dx[i];

            if (nx >= 0 && nx < M) {
                dfs(ny, nx, sum + map[ny][nx], i);
            }
        }
    }
}
// S3 진우의 달 여행 (small) 백트래킹
// 30분
// 일단 처음부터 문제가 3방향 밖에 안가진다는 점으로 방향 벡터 고려했고
// 맨처음에 문제 분석을 할때 가중치가 다르길래 다익스트라 인가 했다 근데 N과 M이 6이 최대여서
// 재귀도 문제없겠다 판단. 기저사례는 N에 대해서 확인가능
// 최선의 값을 가지면서 누적해서 더하는 DP랑 헷갈렸고 접근을 어케 할지 고민 갔던데 방문 X 해야됨
// 그래서 백트래킹 도입 시간복잡도도 문제 없었다.
// M개의 출발점에 있어서 y,x 좌표에 sum 누적합과 dir 을 기억해서 방향에 대해 다를경우 진행하고
// 방문 방문 해제의 백트래킹으로 기저사례로 값 연산 최대 연료가 100이므로 6번 가능하기에 600과 비교연산.
// feedback 백트래킹 == visit 체크 재귀 visit 해제 라는 공식에 얽매여있다.
// 막다른길에서 그냥 반복문 탈출하는게 이게 위로 안올라가니까 다른 길을 가는거랑 같아서
// 굳이 방문여부 체크할 필요가없다 내가 과거에 갔던 위로 안가기 위해서 가지치는건데,,