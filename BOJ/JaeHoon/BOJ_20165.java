package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20165 {
    static int[][] map;
    static int[][] cmap;
    static int N,M,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        cmap = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cmap[i][j] = map[i][j];
            }
        }

        int total = 0;
        for(int i=1; i<=R*2; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(i % 2 != 0) { //공격
                char dir = st.nextToken().charAt(0);
                int score = attack(r,c,dir);
                total += score;
            }else { // 수비
                map[r][c] = cmap[r][c];
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                sb.append(map[i][j] == 0 ? "F " : "S ");
            }
            sb.append("\n");
        }

        System.out.println(total);
        System.out.println(sb);
    }
    public static int attack(int r, int c, char dir) {
        int score = 0;
        if(dir == 'N') {
            int max = map[r][c];
            for(int i=r; i>=1; i--) {
                if(max > 0) {
                    if(max < map[i][c]) max = map[i][c];
                    if(map[i][c] != 0) score++;
                    map[i][c] = 0;
                    max-=1;
                }
            }
        }

        if(dir == 'S') {
            int max = map[r][c];
            for(int i=r; i<=N; i++) {
                if(max > 0) {
                    if(max < map[i][c]) max = map[i][c];
                    if(map[i][c] != 0) score++;
                    map[i][c] = 0;
                    max-=1;
                }
            }
        }

        if(dir == 'E') {
            int max = map[r][c];
            for(int i=c; i<=M; i++) {
                if(max > 0) {
                    if(max < map[r][i]) max = map[r][i];
                    if(map[r][i] != 0) score++;
                    map[r][i] = 0;
                    max-=1;
                }
            }
        }

        if(dir == 'W') {
            int max = map[r][c];
            for(int i=c; i>=1; i--) {
                if(max > 0) {
                    if(max < map[r][i]) max = map[r][i];
                    if(map[r][i] != 0) score++;
                    map[r][i] = 0;
                    max-=1;
                }
            }
        }

        return score;
    }
}
