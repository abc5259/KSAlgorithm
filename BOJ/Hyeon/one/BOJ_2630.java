package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int white, blue;
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

// S2 색종이 만들기 분할정복 재귀
// 4가지로 나누는데 size를 2로 나눠서 이를 열과 행의 계산으로 해서 4개의 부분으로 나눈다
// 이때 0,0좌표부터 시작한다 치고 분할하고 정복하기 전의 기저 를 정해야되는데
// 지금 현재 좌표와 다른 색깔의 색종이가 있는지 검사하고 있다면 end 플래그를 false로 두고
// recursion 재귀를 진행한다 그전에 size를 2로 나눠서 분할해주고
// 계속해서 정복하고 해당 분할된 곳에서 다른 색이 없을경우 시작좌표에 해당하는 색의 값을 증가시킨다.