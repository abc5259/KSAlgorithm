package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22944 {
    static int N,H,D;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited = new int[N][N];
        int[] start = new int[2];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        System.out.println(bfs(start));
    }

    public static int bfs(int[] start) {
        visited[start[0]][start[1]] = H;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start[0], start[1], H, 0, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(map[nx][ny] == 'E') {
                    return cur.cnt + 1;
                }
                int nextHp = cur.hp;
                int nextUHp = map[nx][ny] == 'U' ? D : cur.uHp;
                if(nextUHp > 0) {
                    nextUHp--;
                }else {
                    nextHp--;
                }

                // 죽는 경우 큐에서 제외
                if(nextHp <= 0) continue;

                if(visited[nx][ny] < nextHp) {
                    visited[nx][ny] = nextHp;
                    q.offer(new Point(nx,ny,nextHp, nextUHp, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
    static class Point {
        int x,y,hp,uHp,cnt;

        public Point(int x, int y, int hp, int uHp, int cnt) {
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.uHp = uHp;
            this.cnt = cnt;
        }
    }
}
