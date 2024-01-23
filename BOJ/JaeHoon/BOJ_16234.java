package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N,L,R;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            boolean isOk = false;
            isVisited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(isVisited[i][j]) continue;
                    boolean ok = bfs(new int[]{i, j});
                    if(ok) isOk = true;
//                    System.out.println("ok = " + ok);
                }
            }

            if(isOk) {
                answer++;
            }else {
                break;
            }
        }

        System.out.println(answer);
    }
    public static boolean bfs(int[] start) {
        isVisited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        int cnt = 1;
        int sum = map[start[0]][start[1]];

        ArrayList<int[]> group = new ArrayList<>();
        group.add(start);

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || isVisited[nx][ny]) continue;

                int dif = Math.abs(map[nx][ny] - map[curr[0]][curr[1]]);
                if(dif >= L && dif <= R) {
                    cnt++;
                    sum += map[nx][ny];
                    isVisited[nx][ny] = true;

                    int[] next = new int[]{nx, ny};
                    group.add(next);
                    q.offer(next);
                }
            }
        }

        int population = sum / cnt;
        for (int[] g : group) {
            map[g[0]][g[1]] = population;
        }

        return cnt > 1;
    }
}
