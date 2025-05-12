package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int white = 0, blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void recursion(int row, int col, int N) {

        int color = paper[row][col];
        boolean end = true;

        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (color != paper[i][j]) {
                    end = false;
                    break;
                }
            }
        }
        
        if (end) {
            if (paper[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int size = N / 2;
        recursion(row, col, size);
        recursion(row, col + size, size);
        recursion(row + size, col, size);
        recursion(row + size, col + size, size);
    }
}
