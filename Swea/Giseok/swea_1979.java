/**
 * 1979. 어디에 단어가 들어갈 수 있을까 (D2|구현) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1979 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int ret = 0;
            String[] puzzle = new String[n];
            for (int i = 0; i < n; i++) {
                puzzle[i] = br.readLine().replace(" ", "");
                String[] tmp = puzzle[i].split("0");
                for (int j = 0; j < tmp.length; j++) {
                    if (tmp[j].length() == k) ret++;
                }
            }

            for (int x = 0; x < puzzle[0].length(); x++) {
                String tmp = "";
                for (int y = 0; y < n; y++) {
                    tmp += puzzle[y].charAt(x);
                }

                String[] temp = tmp.split("0");
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].length() == k) ret++;
                }
            }

            System.out.println("#" + t + " " + ret);

            /* ver2
            int ret = 0;

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) cnt++;
                    else {
                        if (cnt == k) ret++;
                        cnt = 0;
                    }
                }
                if (cnt == k) ret++;
            }

            for (int x = 0; x < n; x++) {
                int cnt = 0;
                for (int y = 0; y < n; y++) {
                    if (map[y][x] == 1) cnt++;
                    else {
                        if (cnt == k) ret++;
                        cnt = 0;
                    }
                }
                if (cnt == k) ret++;
            }

            System.out.println("#" + t + " " + ret);
             */
        }
    }
}