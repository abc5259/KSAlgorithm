package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9376 {
    static char[][] map;
    static int N,M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int INF = 30000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] p1 = new int[2];
            int[] p2 = new int[2];
            map = new char[N+2][M+2];
            for(int i=0; i<=N+1; i++) {
                for(int j=0; j<=M+1; j++) {
                    map[i][j] = '.';
                }
            }
            for(int i=1; i<=N; i++) {
                String s = br.readLine();
                for(int j=1; j<=M; j++) {
                    map[i][j] = s.charAt(j-1);
                    if(map[i][j] == '$') {
                        if(p1[0] == 0) {
                            p1[0] = i;
                            p1[1] = j;
                        }else {
                            p2[0] = i;
                            p2[1] = j;
                        }
                    }
                }
            }

            int[][] result1 = bfs(0, 0);
            int[][] result2 = bfs(p1[0], p1[1]);
            int[][] result3 = bfs(p2[0], p2[1]);

            int min = Integer.MAX_VALUE;
            for(int i=0; i<=N+1; i++) {
                for(int j=0; j<=M+1; j++) {
                    int sum = result1[i][j] + result2[i][j] + result3[i][j];
                    if(map[i][j] == '#') {
                        sum -= 2;
                    }
                    min = Math.min(min, sum);
                }

            }
            sb.append(min).append('\n');
        }
        System.out.print(sb);
    }

    public static int[][] bfs(int x, int y) {
        int[][] result = new int[N+2][M+2];
        for(int i=0; i<=N+1; i++) {
            for(int j=0; j<=M+1; j++) {
                result[i][j] = INF;
            }
        }
        result[x][y] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.doorCnt - b.doorCnt);
        boolean[][] isVisited = new boolean[N+2][M+2];
        pq.offer(new Point(x, y, 0));
        isVisited[x][y] = true;

        while (!pq.isEmpty()) {
            Point curr = pq.poll();

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2 || isVisited[nx][ny]) continue;
                if(map[nx][ny] == '*') continue;

                isVisited[nx][ny] = true;
                result[nx][ny] = map[nx][ny] == '#' ? curr.doorCnt + 1 : curr.doorCnt;
                pq.offer(new Point(nx, ny, result[nx][ny]));
            }
        }

        return result;
    }
    static class Point {
        int x,y,doorCnt;

        public Point(int x, int y, int doorCnt) {
            this.x = x;
            this.y = y;
            this.doorCnt = doorCnt;
        }
    }
}
