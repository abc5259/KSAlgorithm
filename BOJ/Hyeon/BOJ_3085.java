package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    static char[][] candy;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        candy = new char[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            candy[i] = br.readLine().toCharArray();
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, countCandy());
                    swap(i, j, i, j + 1);
                }
                if (i < N - 1) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, countCandy());
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.print(max);
    }

    static void swap(int row1, int col1, int row2, int col2) {
        char tmp = candy[row1][col1];
        candy[row1][col1] = candy[row2][col2];
        candy[row2][col2] = tmp;
    }

    static int countCandy() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cntRow = 1;
            int cntCol = 1;

            for (int j = 1; j < N; j++) {
                if (candy[i][j - 1] == candy[i][j]) {
                    cntRow++;
                } else {
                    max = Math.max(max, cntRow);
                    cntRow = 1;
                }

                if (candy[j - 1][i] == candy[j][i]) {
                    cntCol++;
                } else {
                    max = Math.max(max, cntCol);
                    cntCol = 1;
                }
            }
            max = Math.max(max, cntCol);
            max = Math.max(max, cntRow);
        }
        return max;
    }
}

// S2 사탕 게임 브루트포스
// 일단 풀긴했는데 겨우 풀어서 다른 풀이보고 공부해야됨
// retry 필
// 부상이라서 어렵다