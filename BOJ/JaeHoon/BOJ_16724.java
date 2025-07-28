package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_16724 {

    static int N, M;
    static char[][] map;
    static Map<Character, Integer> dMap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        dMap = new HashMap<>();
        dMap.put('U', 0);
        dMap.put('L', 1);
        dMap.put('D', 2);
        dMap.put('R', 3);

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        int curr = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(bfs(i, j, curr)) {
                    cnt++;
                }
                curr++;
            }
        }

        System.out.println(cnt);
    }

    static boolean bfs(int x, int y, int v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = v;
        boolean check = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int idx = dMap.get(map[cur[0]][cur[1]]);
            int nx = cur[0] + dx[idx];
            int ny = cur[1] + dy[idx];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny] == v) continue;
            if (visited[nx][ny] != 0) {
                check = false;
                visited[nx][ny] = v;
                continue;
            }
            visited[nx][ny] = v;
            q.add(new int[]{nx, ny});
        }
        return check;
    }
}
