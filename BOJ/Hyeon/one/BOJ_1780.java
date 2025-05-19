package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int[][] papers;
    static int minus = 0;
    static int zero = 0;
    static int one = 0;

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

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void cutting(int row, int col, int N) {
        if (isSame(row, col, N)) {
            if (papers[row][col] == -1) {
                minus++;
            } else if (papers[row][col] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        int size = N / 3;

        cutting(row, col, size);
        cutting(row, col + size, size);
        cutting(row, col + 2 * size, size);

        cutting(row + size, col, size);
        cutting(row + size, col + size, size);
        cutting(row + size, col + 2 * size, size);

        cutting(row + 2 * size, col, size);
        cutting(row + 2 * size, col + size, size);
        cutting(row + 2 * size, col + 2 * size, size);


    }

    private static boolean isSame(int row, int col, int size) {
        int num = papers[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// S2 종이의 개수 분할 정복 재귀
// 색종이와 문제가 일치하다 로직도 같다
// 분할해서 9개라서 3으로 나누고 해당 인덱스마다 재귀해서 들어간다
// 색이 같은지에 대한 기저조건을 설정하고 숫자가 일치할 경우 맨앞숫자에 대한 변수의 값을 증가시키고
// return으로 탈출한다.