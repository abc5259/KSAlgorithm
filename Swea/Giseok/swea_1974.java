/**
 * 1974. 스도쿠 검증 (D2|구현) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1974 {

    static boolean[] numbers;

    public static boolean isNotCorrect() {
        for (int i = 1; i <= 9; i++) {
            if (!numbers[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            boolean gameflag = false;
            int[][] map = new int[9][9];

            for (int y = 0; y < 9; y++) {
                numbers = new boolean[10];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 9; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    numbers[map[y][x]] = true;
                }
                if (isNotCorrect()) gameflag = true;
            }

            for (int y = 0; y < 9; y+=3) {
                for (int x = 0; x < 9; x+=3) {

                    numbers = new boolean[10];
                    for (int yy = y; yy < y + 3; yy++) {
                        for (int xx = x; xx < x + 3; xx++) numbers[map[yy][xx]] = true;
                    }
                    if (isNotCorrect()) gameflag = true;
                }
            }

            for (int x = 0; x < 9; x++) {
                numbers = new boolean[10];
                for (int y = 0; y < 9; y++) numbers[map[y][x]] = true;
                if (isNotCorrect()) gameflag = true;
            }

            System.out.println("#" + t + " " + (gameflag ? 0 : 1));
        }
    }
}