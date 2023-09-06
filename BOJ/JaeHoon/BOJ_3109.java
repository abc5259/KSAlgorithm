package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
    static int R,C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dp;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];
        dp = new int[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                 map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<R; i++) {
            solve(i,0);
        }
        System.out.println(answer);
    }
    public static boolean solve(int x, int y) {


        if(y == C - 1) {
            answer++;
            return true;
        }

        for(int i=0; i<3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if(map[nextX][nextY] == 'x' || map[nextX][nextY] == '-') continue;
            map[nextX][nextY] = '-';
            if(solve(nextX,nextY)) return true;
        }
        return false;
    }
}
