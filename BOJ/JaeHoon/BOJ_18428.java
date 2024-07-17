package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18428 {
    static int N;
    static char[][] map;
    static List<int[]> tArr;
    static boolean[][] isVisited;
    static int[] dx = {0,-1,1,0};
    static int[] dy = {1,0,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        isVisited = new boolean[N][N];
        tArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') {
                    tArr.add(new int[] {i, j});
                }
            }
        }

        boolean solve = solve(0);
        System.out.println(solve ? "YES" : "NO");
    }

    static boolean solve(int depth) {
//        if(startX >= N) return false;

        if(depth == 3) {
            return find();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isVisited[i][j]) continue;
                if(map[i][j] == 'X') {
                    map[i][j] = 'O';
                    isVisited[i][j] = true;
                    boolean clear = solve(depth+1);
                    map[i][j] = 'X';
                    isVisited[i][j] = false;
                    if(clear) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean find() {
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                sb.append(map[i][j] + " ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
        for(int[] p: tArr) {
            for(int d=0; d<4; d++) {
                int nx = p[0];
                int ny = p[1];
                while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(map[nx][ny] == 'S') {
                        return false;
                    }
                    if(map[nx][ny] == 'O') {
                        break;
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        return true;
    }
}
