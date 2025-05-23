package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int blue = 0, white = 0;
    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutting(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void cutting(int row, int col, int size) {
        if (isColor(row, col, size)) {
            if (papers[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        int newSize = size / 2;
        cutting(row, col, newSize);
        cutting(row, col + newSize, newSize);
        cutting(row + newSize, col, newSize);
        cutting(row + newSize, col + newSize, newSize);
    }

    static boolean isColor(int row, int col, int size) {
        int tmp = papers[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (tmp != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
