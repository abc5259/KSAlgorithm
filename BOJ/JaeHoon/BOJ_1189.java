package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {

    static int R,C,K;
    static char[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int count = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(count);
    }
    public static void dfs(int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            if(cnt == K) count++;
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(map[nx][ny] == 'T' || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1);
            visited[nx][ny] = false;
        }
    }
}
