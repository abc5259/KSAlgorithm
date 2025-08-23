package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736 {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N,M;

    public static void main(String[] args) throws IOException {
        //시작: 10:04

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        int[] start = new int[2];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int cnt = bfs(start);
        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    public static int bfs(int[] start) {
        int cnt = 0;
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;

                if(map[nx][ny] == 'P') cnt++;
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }

        return cnt;
    }
}
