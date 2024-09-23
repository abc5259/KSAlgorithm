package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int N, M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
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
                if(map[i][j] > 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int cnt = 1;
        while (true) {
            boolean isMelt = melt();
            if(isMelt) {
                if(q.isEmpty()) {
                    cnt = 0;
                   break;
                }
                int qCnt = bfs();
                if(qCnt != q.size()) {
                    break;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
    static int bfs() {
        Queue<int[]> bfsQ = new LinkedList<>();
        int[] peek = q.peek();
        bfsQ.add(peek);
        boolean[][] visited = new boolean[N][M];
        visited[peek[0]][peek[1]] = true;
        int cnt = 0;
        while (!bfsQ.isEmpty()) {
            cnt++;
            int[] curr = bfsQ.poll();
            for(int d=0; d<4; d++) {
                int x = curr[0] + dx[d];
                int y = curr[1] + dy[d];

                if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] <= 0) continue;
                visited[x][y] = true;
                bfsQ.offer(new int[]{x, y});
            }
        }

        return cnt;
    }
    static boolean melt() {
        Queue<int[]> meltQ = new LinkedList<>();
        int size = q.size();
        for(int i=0; i<size; i++) {
            int[] curr = q.poll();

            int cnt = 0;
            for(int d=0; d<4; d++) {
                int x = curr[0] + dx[d];
                int y = curr[1] + dy[d];
                if(map[x][y] <= 0) {
                    cnt++;
                }
            }

            if(map[curr[0]][curr[1]] - cnt <= 0) {
                meltQ.offer(new int[]{curr[0], curr[1]});
            }else {
                map[curr[0]][curr[1]] -= cnt;
                q.offer(new int[]{curr[0], curr[1]});
            }
        }

        if(!meltQ.isEmpty()) {
            while (!meltQ.isEmpty()) {
                int[] p = meltQ.poll();
                map[p[0]][p[1]] = 0;
            }

            return true;
        }

        return false;
    }
}
