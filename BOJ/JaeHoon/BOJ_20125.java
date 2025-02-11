package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20125 {
    static char[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int[] heart = findHeart(N);
        int left = solve(new int[]{heart[0], heart[1]-1}, 1, N);
        int right = solve(new int[]{heart[0], heart[1]+1}, 0, N);
        int under = solve(new int[]{heart[0]+1, heart[1]}, 3, N);
        int leftLeg = solve(new int[]{heart[0] + under + 1, heart[1]-1}, 3, N);
        int rightLeg = solve(new int[]{heart[0] + under + 1, heart[1]+1}, 3, N);
        System.out.printf("%d %d\n%d %d %d %d %d", heart[0] + 1, heart[1] + 1, left, right, under, leftLeg, rightLeg);
    }

    private static int solve(int[] start, int dir, int N) {
        int x = start[0];
        int y = start[1];
        int cnt = 1;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if(map[nx][ny] == '_') break;
            cnt++;
            x = nx;
            y = ny;
        }
        return cnt;
    }

    private static int[] findHeart(int N) {
        for(int i = 0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                if(isHeart(i,j, N)) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static boolean isHeart(int i, int j, int N) {
        for(int d=0; d<4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map[nx][ny] == '_') {
                return false;
            }
        }
        return true;
    }
}
