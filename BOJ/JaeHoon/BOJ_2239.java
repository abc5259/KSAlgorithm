package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239 {

    static int N = 9;
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        solve(0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static boolean solve(int x, int y) {
        if (x >=N) {
            return true;
        }
        if (y >= N) {
            return solve(x + 1, 0);
        }
        if (map[x][y] != 0) {
            return solve(x, y + 1);
        }
        for(int k=1; k<=9; k++) {
            if(check(x, y, k)) {
                map[x][y] = k;
                if(solve(x, y+1)) {
                    return true;
                }
                map[x][y] = 0;
            }
        }
        return false;
    }

    public static boolean check(int x, int y, int k) {
        for(int i=0; i<N; i++) {
            if(map[i][y] == k) return false;
        }

        for(int i=0; i<N; i++) {
            if(map[x][i] == k) return false;
        }

        if (x <= 2 && y <= 2) {
            for (int i=0; i<=2; i++) {
                for(int j=0; j<=2; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 2 && y <= 5) {
            for (int i=0; i<=2; i++) {
                for(int j=3; j<=5; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 2 && y <= 8) {
            for (int i=0; i<=2; i++) {
                for(int j=6; j<=8; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 5 && y <= 2) {
            for (int i=3; i<=5; i++) {
                for(int j=0; j<=2; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 5 && y <= 5) {
            for (int i=3; i<=5; i++) {
                for(int j=3; j<=5; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 5 && y <= 8) {
            for (int i=3; i<=5; i++) {
                for(int j=6; j<=8; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 8 && y <= 2) {
            for (int i=6; i<=8; i++) {
                for(int j=0; j<=2; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 8 && y <= 5) {
            for (int i=6; i<=8; i++) {
                for(int j=3; j<=5; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        else if (x <= 8 && y <= 8) {
            for (int i=6; i<=8; i++) {
                for(int j=6; j<=8; j++) {
                    if(map[i][j] == k) return false;
                }
            }
        }
        return true;
    }
}
