package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int R,C,N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                if(s.charAt(j) == '.') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        solve();
        print();
    }

    public static void solve() {
        int time = 1;
        while (time < N) {
            time++;
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] == -1) {
                        map[i][j] = 0;
                    } else {
                        map[i][j]++;
                    }
                }
            }
            if(time == N) break;
            time++;
            Queue<int[]> q = new ArrayDeque<>();
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] != -1) {
                        map[i][j]++;
                        if(map[i][j] == 3) {
                            q.offer(new int[]{i, j});
                        }
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                map[cur[0]][cur[1]] = -1;
                for(int i=0; i<4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];
                    if(x < 0 || x >= R || y < 0 || y >= C) continue;
                    map[x][y] = -1;
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == -1) {
                    sb.append(".");
                }else {
                    sb.append('O');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
