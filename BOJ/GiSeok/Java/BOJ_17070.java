/**
 * 17070 - 파이프 옮기기 1 [성공|00:39:19]
 * 골드5, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17070 {
    // 시간제한 1초, 메모리제한 512MB

    static int n;
    static int ret;
    static int[][] map;
    static int[][] dp;

    static void go(int[][] copy, int sy, int sx, int ey, int ex) {

        if (ey == n-1 && ex == n-1) { ret++; return; }

        // 가로
        if (sx == ex-1 && sy == ey || sx == ex-1 && sy == ey-1) {
            if (ex + 1 < n && copy[ey][ex + 1] == 0) {
                copy[sy][sx] = 0;
                copy[ey][ex + 1] = 2;
                go(copy, ey, ex, ey, ex + 1);
                copy[sy][sx] = 2;
                copy[ey][ex + 1] = 0;
            }
        }

        // 세로
        if (sx == ex && sy == ey-1 || sx == ex-1 && sy == ey-1) {
            if (ey + 1 < n && copy[ey + 1][ex] == 0) {
                copy[sy][sx] = 0;
                copy[ey + 1][ex] = 2;
                go(copy, ey, ex, ey + 1, ex);
                copy[sy][sx] = 2;
                copy[ey + 1][ex] = 0;
            }
        }

        // 대각선
        if (ey + 1 < n && ex + 1 < n) {
            if (map[ey+1][ex] == 0 && map[ey][ex+1] == 0 && map[ey+1][ex+1] == 0) {
                copy[sy][sx] = 0;
                copy[ey+1][ex+1] = 2;
                go(copy, ey, ex, ey+1, ex+1);
                copy[sy][sx] = 2;
                copy[ey+1][ex+1] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) map[y][x] = Integer.parseInt(st.nextToken());
        }

        map[0][0] = 2;
        map[0][1] = 2;
        go(map, 0,0, 0, 1);
        System.out.println(ret);
    }
}
