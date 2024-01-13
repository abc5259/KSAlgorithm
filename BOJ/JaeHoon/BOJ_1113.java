package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1113 {

    static int N,M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        isVisited = new boolean[N+2][M+2];

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        int answer = 0;
        for(int h=1; h<=9; h++) {
            isVisited = new boolean[N+2][M+2];
            for(int i=2; i<=N-1; i++) {
                for(int j=2; j<=M-1; j++) {
                    if(isVisited[i][j] || map[i][j] != h) continue;
                    int add = bfs(new int[]{i, j});
                    answer += add;
                }
            }
        }

        System.out.println(answer);
    }
    public static int bfs(int[] start) {
        int wallHeight = 10;
        ArrayList<int[]> arr = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        arr.add(start);
        q.offer(start);

        int h = map[start[0]][start[1]];
        isVisited[start[0]][start[1]] = true;


        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];


                if(map[nx][ny] == 0) {
                    for(int[] p: arr) {
                        isVisited[p[0]][p[1]] = false;
                    }
                    return 0;
                }

                if(isVisited[nx][ny]) continue;
                if(h < map[nx][ny]) {
                    wallHeight = Math.min(wallHeight, map[nx][ny]);
                    continue;
                }

                int[] next = new int[]{nx,ny};
                isVisited[nx][ny] = true;
                q.offer(next);
                arr.add(next);
            }
        }

        if(wallHeight != 10) {
            int sum = 0;
            for(int[] p: arr) {
                sum += (wallHeight - map[p[0]][p[1]]);
                map[p[0]][p[1]] = wallHeight;
            }
            return sum;
        }

        for(int[] p: arr) {
            isVisited[p[0]][p[1]] = false;
        }
        return 0;
    }
}
