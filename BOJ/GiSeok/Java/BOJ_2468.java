/**
 * 2468 - 안전 영역 [성공|00:31:17]
 * 실버1, 그래프 이론, 시도3(반례힌트)
 * 
 * map이 주어지고 각 요소마다 높이 정보가 주어짐
 * 높이에 따라 비에 잠길 수도 있고 잠기지 않을 수도 있다.
 * 높이 1 ~ 100이 주어졌을 때 비에 잠기지 않는 연결된 컴포넌트 최대 갯수는?
 * 높이가 1 ~ 100 이라는 것에 꽂혀서 비가 오지 않는 경우의 수를 예상하지 못했다.
 * 1
 * 1 1
 * 과 같이 그래프가 주어졌을 때 비가 오지 않으면 1개 이후 비가 오면 모두 0개이다.
 * 비가 오지 않는 경우를 고려해줘야 최대 갯수를 구할 수 있게된다.
 * 노트에 *아무 지역도 물에 잠기지 않을 수도 있다.*가 힌트였다.
 * 비가 오는 순간 높이가 1부터 잠긴다. 반대로 이 문장을 생각하면
 * 높이가 1이어도 아무 지역도 물에 잠기지 않을 수도 있다기 때문에
 * = 비가 안 올수도 있다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
    // 어떤 지역의 높이 정보 -> map
    // 많은 비가 내렸을 때 물에 잠기지 않는 안전 영역이 몇 개?
    // 일정한 높이 이하의 모든 지점은 물에 잠김
    // 비가 내린 뒤 잠기지 않는 인접(상하좌우)한 지역들의 갯수
    // = 연결 컴포넌트 문제
    // 여기서 이제 연결 컴포넌트의 최대 갯수를 구하는 문제임.

    static class Pair {
        int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int N, H;
    static int cnt;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (H = 0; H <= 100; H++) {
            visited = new boolean[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > H && !visited[i][j]) { 
                        dfs(new Pair(i, j));
                        sum++;
                    }
                }
            }
            cnt = Math.max(cnt, sum);
        }

        System.out.println(cnt);
    }

    static void dfs(Pair p) {
        visited[p.y][p.x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if (ny < 0 || nx < 0 || nx >= N || ny >= N) continue;
            if (map[ny][nx] <= H) continue;
            if (visited[ny][nx]) continue;

            dfs(new Pair(ny, nx));
        }
    }
}
