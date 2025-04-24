package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BA {
    static int N;
    static char[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];
        for (int i = 0; i < N; i++) {
            candy[i] = br.readLine().toCharArray();
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    if (candy[i][j] != candy[i][j + 1]) {
                        swap(i, j, i, j + 1);
                        max = Math.max(max, count());
                        swap(i, j, i, j + 1);
                    }
                }
                if (i < N - 1) {
                    if (candy[i][j] != candy[i + 1][j]) {
                        swap(i, j, i + 1, j);
                        max = Math.max(max, count());
                        swap(i, j, i + 1, j);
                    }
                }
            }
        }
        System.out.print(max);
    }

    static int count() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int rowCnt = 1;
            int colCnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candy[i][j] == candy[i][j + 1]) {
                    colCnt++;
                } else {
                    max = Math.max(max, colCnt);
                    colCnt = 1;
                }

                if (candy[j][i] == candy[j + 1][i]) {
                    rowCnt++;
                } else {
                    max = Math.max(max, rowCnt);
                    rowCnt = 1;
                }
            }
            max = Math.max(max, colCnt);
            max = Math.max(max, rowCnt);
        }
        return max;
    }

    static void swap(int row1, int col1, int row2, int col2) {
        char tmp = candy[row1][col1];
        candy[row1][col1] = candy[row2][col2];
        candy[row2][col2] = tmp;
    }
}
