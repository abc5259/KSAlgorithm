/**
 * 2178 - 미로 탐색 [성공|13:37]
 * 실버1, BFS, 시도1
 * 
 * map 배열이 주어지고, 해당 맵에서 좌표 -> 좌표 최단거리를 구하는 문제
 * = BFS
 * 배열 하나의 원소를 노드로 보고 1이면 서로 이어진 노드로 이루어진 그래프로 보면 된다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2178 {
    // N*M 크기의 배열로 표현된 미로가 있다.
    // 1 : 이동할 수 있는 칸
    // 0 : 이동할 수 없는 칸
    // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나는 최소의 칸 수 == BFS
    // 상하좌우로만 이동
    static class Pair {
        int x, y;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] maze;
    static int[][] visited;
    static int N, M;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++)
                maze[i][j] = s.charAt(j) - '0';
        }

        bfs(new Pair(0, 0));
        System.out.println(visited[N-1][M-1]);
    }

    static void bfs(Pair p) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(p);
        visited[p.y][p.x] = 1;

        while (!q.isEmpty()) {
            Pair r = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = r.y + dy[i];
                int nx = r.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (maze[ny][nx] == 0) continue;
                if (visited[ny][nx] > 0) continue;

                visited[ny][nx] = visited[r.y][r.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
    }
}
