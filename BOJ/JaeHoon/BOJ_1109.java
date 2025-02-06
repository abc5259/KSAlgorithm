package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1109 {
    static int N,M;
    static char[][] map;
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,-1,1,-1,1};
    static boolean[][] isVisited;
    static List<List<int[]>> lands = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int id = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(isVisited[i][j] || map[i][j] == '.') continue;
                lands.add(new ArrayList<>());
                bfs(id++,i,j);
            }
        }

        for (List<int[]> land : lands) {

        }
    }

    public static void bfs(int id, int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx,sy});
        isVisited[sx][sy] = true;
        lands.get(id).add(new int[]{sx,sy});
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<8; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || isVisited[nx][ny]) continue;
                if(map[nx][ny] == '.') continue;
                int[] next = {nx, ny};
                isVisited[nx][ny] = true;
                lands.get(id).add(next);
                q.offer(next);
            }
        }
    }
}
