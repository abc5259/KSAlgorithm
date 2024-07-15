/**
 * 2583 - 영역 구하기 [성공|00:39:54]
 * 실버1, 그래프 이론, 시도1
 * 
 * 영역 구하기 문제는 좌표로 주어진 직사각형을 제외한 영역의 갯수와 넓이를 구하는 문제이다.
 * 영역의 갯수는 연결 컴포넌트 문제로 해결이 가능하고,
 * 넓이는 해당 영역의 요소 전체 갯수를 구하면 된다.
 * 
 * 넓이를 구하는 것에 좀 시간이 걸렸던 문제이다.
 * dfs는 최대한 깊이까지 갔다가 되돌아오는 특성을 가진 알고리즘이기 때문에
 * dfs 내부에 cnt라는 변수를 두고 더 이상 자식이 없을 때 1로 초기화 된 cnt를 반환하면서
 * 호출한 부분의 cnt에 더하는 방식으로 갯수를 카운트했다.
 * 
 * 시간 복잡도는 입력 100 + dfs 100^3 + 정렬 100^2 = 대충 100만 O(N^3)
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2583 {
    // 눈금의 간격이 1 => 가중치 1
    // M*N 크기의 모눈종이
    // 직사각형을 그리고 직사각형에 해당되지 않는 부분의 전체 갯수와 넓이
    // => 연결된 컴포넌트 문제

    static class Pair {
        int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int M, N, K;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = -1;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != -1 && !visited[i][j]) {
                    ans.add(dfs(new Pair(i, j)));
                    cnt++;
                }
            }
        }

        ans.sort(null);
        System.out.println(cnt);
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
        System.out.println();
    }

    static int dfs(Pair v) {
        visited[v.y][v.x] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int ny = v.y + dy[i];
            int nx = v.x + dx[i];

            if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
            if (map[ny][nx] == -1) continue;
            if (visited[ny][nx]) continue;

            cnt += dfs(new Pair(ny, nx));
        }

        return cnt;
    }
}
