package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11123 {
    static int N,M;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            isVisit = new boolean[N][M];

            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            int answer = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!isVisit[i][j] && map[i][j] == '#') {
                        isVisit[i][j] = true;
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int r, int c) {
        if(r == N && c == M) {
            return;
        }

        for(int i=0; i<4; i++) {
            int nextX = r + dx[i];
            int nextY = c + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
            if(map[nextX][nextY] == '.' || isVisit[nextX][nextY]) continue;

            isVisit[nextX][nextY] =  true;
            dfs(nextX,nextY);
        }
    }
}
