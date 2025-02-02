package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087 {
    static int W,H;
    static char[][] map;
    static int[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0}; //우, 좌, 아래, 위
    static Dir[][] dirs = {
            {new Dir(0,0), new Dir(1,2), new Dir(1,3)},
            {new Dir(0,1), new Dir(1,2), new Dir(1,3)},
            {new Dir(0,2), new Dir(1,0), new Dir(1,1)},
            {new Dir(0,3), new Dir(1,0), new Dir(1,1)}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new int[H][W][4];
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        int[] start1 = new int[2];
        Arrays.fill(start1, -1);
        int[] start2 = new int[2];
        for(int i=0; i<H; i++) {
            String s = br.readLine();
            for(int j=0; j<W; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'C') {
                    if(start1[0] == -1) {
                        start1[0] = i;
                        start1[1] = j;
                    }else {
                        start2[0] = i;
                        start2[1] = j;
                    }
                }
            }
        }
        bfs(start1);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            min = Math.min(min, visited[start2[0]][start2[1]][i]);
        }
        System.out.println(min);
    }

    static void bfs(int[] start) {
        Queue<Point> q = new ArrayDeque<>();
        visited[start[0]][start[1]][0] = 0;
        visited[start[0]][start[1]][1] = 0;
        visited[start[0]][start[1]][2] = 0;
        visited[start[0]][start[1]][3] = 0;
        for(int i=0; i<4; i++) {
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];
            if(nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '*') continue;
            visited[nx][ny][i] = 0;
            q.offer(new Point(nx,ny,i, 0));
        }

        while (!q.isEmpty()) {
            Point curr = q.poll();

            Dir[] dir = dirs[curr.dir];
            for (Dir d : dir) {
                int nx = curr.x + dx[d.d];
                int ny = curr.y + dy[d.d];
                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if(map[nx][ny] == '*') continue;
                if(visited[nx][ny][d.d] <= curr.cnt + d.addCnt) continue;
                visited[nx][ny][d.d] = curr.cnt + d.addCnt;
                q.offer(new Point(nx, ny, d.d, visited[nx][ny][d.d]));
            }
        }
    }
    static class Point {
        int x, y, dir, cnt;

        public Point(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    static class Dir {
        int addCnt, d;

        public Dir(int addCnt, int d) {
            this.addCnt = addCnt;
            this.d = d;
        }
    }
}
