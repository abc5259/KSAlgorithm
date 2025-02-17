package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239 {
    //    static int[][] puzzle;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        puzzle = new int[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < 9; j++) {
//                puzzle[i][j] = str.charAt(j) - '0';
//            }
//        }
//        dfs(0);
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                sb.append(puzzle[i][j]);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }
//
//    static boolean solved = false;
//
//    static void dfs(int num) {
//        if (num == 81) {
//            solved = true;
//            return;
//        }
//        int y = num / 9;
//        int x = num % 9;
//
//        if (puzzle[y][x] != 0) {
//            dfs(num + 1);
//        } else {
//            for (int i = 1; i <= 9; i++) {
//                if (isValid(y, x, i)) {
//                    puzzle[y][x] = i;
//                    dfs(num + 1);
//                    if (solved) return;
//                    puzzle[y][x] = 0;
//                }
//            }
//        }
//    }
//
//    static boolean isValid(int y, int x, int num) {
//        for (int j = 0; j < 9; j++) {
//            if (puzzle[j][x] == num || puzzle[y][j] == num) {
//                return false;
//            }
//        }
//        int y3 = (y / 3) * 3;
//        int x3 = (x / 3) * 3;
//        for (int r = y3; r < y3 + 3; r++) {
//            for (int c = x3; c < x3 + 3; c++) {
//                if (puzzle[r][c] == num)
//                    return false;
//            }
//        }
//        return true;
//    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    }
}
