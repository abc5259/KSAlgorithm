package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057 {
    static int N;
    static int[][] map;
    static int result;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][][] a = {
            {
                    {-1,-1,10}, {-1,0,7}, {-1,1,1}, {-2,0,2},
                    {0,-2,5},
                    {1,-1,10}, {1,0,7}, {1,1,1}, {2,0,2},
            },
            {
                    {1,-1,10}, {0,-1,7}, {-1,-1,1}, {0,-2,2},
                    {2,0,5},
                    {1,1,10}, {0,1,7}, {-1,1,1}, {0,2,2},
            },
            {
                    {-1,1,10}, {-1,0,7}, {-1,-1,1}, {-2,0,2},
                    {0,2,5},
                    {1,1,10}, {1,0,7}, {1,-1,1}, {2,0,2},
            },
            {
                    {1,-1,1}, {0,-1,7}, {-1,-1,10}, {0,-2,2},
                    {-2,0,5},
                    {1,1,1}, {0,1,7}, {-1,1,10}, {0,2,2},
            },
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(N/2, N/2, 0, 1, 1);
        System.out.println(result);
    }

    public static void dfs(int r, int c, int d, int cnt, int end) {
        if(r == 0 && c == 0) {
            return;
        }

        int nx = r;
        int ny = c;
        for(int i=0; i<end; i++) {
            nx += dx[d];
            ny += dy[d];
            int yAmount = map[nx][ny];
            int[][] aa = a[d];
            int sum = 0;
            for(int[] g: aa) {
                int nnx = nx + g[0];
                int nny = ny + g[1];
                int add = yAmount * g[2] / 100;
                sum += add;
                if(nnx < 0 || nnx >= N || nny < 0 || nny >= N) {
                    result += add;
                    continue;
                }
                map[nnx][nny] += add;
            }
            int anx = nx + dx[d];
            int any = ny + dy[d];
            if(anx < 0 || anx >= N || any < 0 || any >= N) {
                result += yAmount - sum;
            }else {
                map[anx][any] += yAmount - sum;
            }
            map[nx][ny] = 0;
            if(nx == 0 && ny == 0) {
                return;
            }
        }

        if(cnt == 2) {
            dfs(nx, ny, (d+1)%4, 1, end+1);
        }else {
            dfs(nx, ny, (d+1)%4, cnt+1, end);
        }
    }
}
