package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int N;
    static int[][] paper;
    static int[] paperNum = new int[3];

    static void divideAndConquer(int row, int column, int max) {
        boolean same = true;
        int num = paper[row][column];

        for (int i = row; i < row + max; i++) {
            for (int j = column; j < column + max; j++) {
                if (num != paper[i][j]) {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            switch (num) {
                case -1:
                    paperNum[0]++;
                    break;
                case 0:
                    paperNum[1]++;
                    break;
                case 1:
                    paperNum[2]++;
                    break;
            }
        } else {
            int m = max / 3;
            for (int r = row; r < row + max; r+=m) {
                for (int c = column; c < column + max; c+=m) {
                    divideAndConquer(r, c, m);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        for (int i = 0; i < 3; i++)
            System.out.println(paperNum[i]);
    }
}
