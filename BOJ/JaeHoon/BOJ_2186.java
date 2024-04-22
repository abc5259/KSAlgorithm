package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2186 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static int[][][] dp;
    static String target;
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        target = br.readLine();
        dp = new int[N][M][target.length()+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == target.charAt(0)) {
                    answer += dfs(1, i, j);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int depth, int r, int c) {

        if(dp[r][c][depth] != -1) {
            return dp[r][c][depth];
        }

        if(depth == target.length()) {
            return 1;
        }

        int cnt = 0;

        for(int i=1; i<=K; i++) {
            for(int d=0; d<4; d++) {
                int nx = r + dx[d]*i;
                int ny = c + dy[d]*i;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] != target.charAt(depth)) continue;

                cnt += dfs(depth+1, nx, ny);
            }
        }

        return dp[r][c][depth] = cnt;

    }
}
