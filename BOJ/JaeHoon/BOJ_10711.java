package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_10711 {
    static int N,M;
    static char[][] map;
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {0, 1, -1, -1, 1, 0, 1, -1};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
//                if(map[i][j] != '.' && map[i][j] != '9') {
////                    System.out.println(" i = " + i + " j = " + j);
//
//                }
            }
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == '.') continue;
                if(isFallen(i,j)) {
                    isVisited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }


        System.out.println(bfs(q));
    }

    public static boolean isFallen(int x, int y) {
        int cnt = 0;
        for(int i=0; i<8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!check(nextX, nextY))
                continue;
            if (map[nextX][nextY] == '.') {
                cnt++;
            }
        }


        return map[x][y] - '0' <= cnt;
    }

    public static boolean check(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    public static int bfs(Queue<int[]> q) {

        int time = 0;
        while (!q.isEmpty()) {
            time++;

            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();

                map[curr[0]][curr[1]] = '.';

                for(int d=0; d<8; d++) {
                    int nextX = curr[0] + dx[d];
                    int nextY = curr[1] + dy[d];

                    if(!check(nextX,nextY)) continue;
                    if(isVisited[nextX][nextY]) continue;
                    if(map[nextX][nextY] == '.' || map[nextX][nextY] == '9') continue;

                    if(isFallen(nextX, nextY)) {
                        isVisited[nextX][nextY] = true;
                        q.offer(new int[]{nextX,nextY});
                    }
                }
            }

        }
        return time;
    }
}
