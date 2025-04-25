package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int sum;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                가로 4칸
                if (j < M - 3) {
                    sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3];
                    max = getMax(max, sum);
                }
//                세로 4칸
                if (i < N - 3) {
                    sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j];
                    max = getMax(max, sum);
                }
//                노란색
                if (i < N - 1 && j < M - 1) {
                    sum = board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1];
                    max = getMax(max, sum);
                }
//                주황색
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1];
                    max = getMax(max, sum);
                }
//                주황색 좌우대칭
                if (i < N - 2 && j < M - 1) {
                    sum = board[i + 2][j] + board[i + 2][j + 1] + board[i + 1][j + 1] + board[i][j + 1];
                    max = getMax(max, sum);
                }
//                주황색 상하대칭
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i][j + 1];
                    max = getMax(max, sum);
                }
//                주황색 대각선 대칭
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
                    max = getMax(max, sum);
                }
//                주황색 좌우 대칭 + 오른쪽 90도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
                    max = getMax(max, sum);
                }
//                주황색 + 오른쪽 270도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2] + board[i][j + 2];
                    max = getMax(max, sum);
                }
//                주황색 좌우 대칭 + 오른쪽 270도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 2];
                    max = getMax(max, sum);
                }
//                주황색 + 오른쪽 90도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j];
                    max = getMax(max, sum);
                }
//                초록색
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j] + board[i + 1][j + 1] + board[i + 1][j] + board[i + 2][j + 1];
                    max = getMax(max, sum);
                }
//                초록색 좌우 대칭
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j] + board[i + 2][j];
                    max = getMax(max, sum);
                }
//                초록색 오른쪽 90도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i][j + 2];
                    max = getMax(max, sum);
                }
//                초록색 좌우 대칭 + 오른쪽 90도
                if (i < N - 1 && j < M - 2) {
                    sum = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j + 2];
                    max = getMax(max, sum);
                }
//                분홍색
                if (i < N - 1 && j < M - 2) {
                    sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 1];
                    max = getMax(max, sum);
                }
//                분홍색 상하 대칭
                if (i < N - 1 && j < M - 2) {
                    sum = board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2] + board[i][j + 1];
                    max = getMax(max, sum);
                }
//                분홍색 + 오른쪽 90도
                if (i < N - 2 && j < M - 1) {
                    sum = board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
                    max = getMax(max, sum);
                }
//                분홍색 좌우 대칭 + 오른쪽 90도
                if (i < N - 2 && j < M - 1) {
                    sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 1][j + 1];
                    max = getMax(max, sum);
                }
            }
        }
        System.out.print(max);
    }

    private static int getMax(int max, int sum) {
        return Math.max(sum, max);
    }
}

// G4 테트로미노 브루트포스
// 5개 종류의 각 도형 폴리오미노를 회전과 대칭을 통해서 N * M 도형의 정사각형 칸이 맞게 차지하여
// 도형의 격자의 새겨진 숫자의 합의 최대값을 구한다.
// 대칭과 회전을 통해 가능한 경우의 수 테트로미노는 총 19개로 브루트포스를 통해 계산한다.
// 이때 반복문을 사용하지 않고 i 와 j의 적절한 범위 제한 조건을 이용하고
// 4개의 칸을 브루트포스로 합산한다.
