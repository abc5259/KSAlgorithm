package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {

    static int R,C,T;
    static int[][] map;
    static int[][] air = {{-1,-1},{-1,-1}};
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] up = {{0,1},{-1,0},{0,-1},{1,0}};
    static int[][] down = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    if(air[0][0] == -1) {
                        air[0][0] = i;
                        air[0][1] = j;
                    }else {
//                        System.out.println(" i = " + i + " j = " + j);
                        air[1][0] = i;
                        air[1][1] = j;
                    }
                }
            }
        }

        while (T-- > 0) {
            solve();
        }

        int sum = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] > 0) sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void solve() {
        diffusion();
        goAir();
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<R; i++) {
//            for(int j=0; j<C; j++) {
//                sb.append(map[i][j] + " ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
    }

    public static void diffusion() {
        int[][] copyMap = new int[R][C];
        copyMap[air[0][0]][air[0][1]] = -1;
        copyMap[air[1][0]][air[1][1]] = -1;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] > 0) {
                    int cnt = 0;
                    int value = map[i][j] / 5;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
                        cnt++;
                        copyMap[nx][ny] += value;
                    }
                    copyMap[i][j] += map[i][j] - value * cnt;
                }
            }
        }

        map = copyMap;
    }

    public static void goAir() {

        for(int i=air[0][0] - 1; i>=0; i--) {
            if(map[i+1][0] == -1) {
                continue;
            }
            map[i+1][0] = map[i][0];
        }

        for(int j=1; j<C; j++) {
            map[0][j-1] = map[0][j];
        }

        for(int i=1; i<=air[0][0]; i++) {
            map[i-1][C-1] = map[i][C-1];
        }

        for(int j=C-2; j>=1; j--) {
            map[air[0][0]][j+1] = map[air[0][0]][j];
        }

        for(int i=air[1][0] + 1; i<R; i++) {
            if(map[i-1][0] == -1) continue;
            map[i-1][0] = map[i][0];
        }

        for(int j=1; j<C; j++) {
            map[R-1][j-1] = map[R-1][j];
        }

        for(int i=R-2; i>=air[1][0]; i--) {
            map[i+1][C-1] = map[i][C-1];
        }

        for(int j=C-2; j>=1; j--) {
            map[air[1][0]][j+1] = map[air[1][0]][j];
        }
        map[air[0][0]][air[0][1] + 1] = 0;
        map[air[1][0]][air[1][1] + 1] = 0;
    }
}
