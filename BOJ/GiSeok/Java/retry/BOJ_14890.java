package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int y = 0; y < n; y++) {

            boolean isPath = true;
            int prev = map[y][0];
            int cnt = 0;
            for (int x = 0; x < n; x++) {
                if (prev == map[y][x]) {
                    cnt++;
                } else if (prev + 1 == map[y][x]) {
                    if (cnt < l) {
                        isPath = false;
                        break;
                    }
                    prev = map[y][x];
                    cnt = 1;
                } else if (prev - 1 == map[y][x]){
                    if (x + l - 1 >= n) {
                        isPath = false;
                        break;
                    }

                    for (int t = x; t < x + l; t++) {
                        if (map[y][x] != map[y][t]) {
                            isPath = false;
                        }
                    }

                    if (isPath) {
                        prev = map[y][x];
                        x += (l - 1);
                        cnt = 0;
                    } else break;
                } else {
                    isPath = false;
                    break;
                }
            }

            if (isPath) ans++;
        }

        for (int x = 0; x < n; x++) {

            boolean isPath = true;
            int prev = map[0][x];
            int cnt = 0;
            for (int y = 0; y < n; y++) {
                if (prev == map[y][x]) {
                    cnt++;
                } else if (prev + 1 == map[y][x]) {
                    if (cnt < l) {
                        isPath = false;
                        break;
                    }
                    prev = map[y][x];
                    cnt = 1;
                } else if (prev - 1 == map[y][x]){
                    if (y + l - 1 >= n) {
                        isPath = false;
                        break;
                    }

                    for (int t = y; t < y + l; t++) {
                        if (map[y][x] != map[t][x]) {
                            isPath = false;
                        }
                    }

                    if (isPath) {
                        prev = map[y][x];
                        y += (l - 1);
                        cnt = 0;
                    } else break;
                } else {
                    isPath = false;
                    break;
                }
            }

            if (isPath) ans++;
        }

        System.out.println(ans);
    }
}
