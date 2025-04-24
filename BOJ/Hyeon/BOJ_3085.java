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
// 일단 풀어가는 과정 자체를 사탕 배열을 만들고 max로 결과값을 구한다.
// 그다음 다른 사탕을 마주했을 때 자리를 바꿔서 현재까지의 최고로 긴 열이나 행의 값을 count메소드를 통해 구하고
// 다시 원상복귀를 시켜야한다.
// 행끼리 전환되거나 열끼리 전환되거나 N-1 을 통해서 가장 끝의 열과 행은 비교안해도 되는것을 생각해야한다.