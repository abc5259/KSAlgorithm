package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int[][] papers;
    static int minus, zero, plus;

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
        System.out.println(plus);
    }

    static void cutting(int row, int col, int size) {
        if (isSame(row, col, size)) {
            int num = papers[row][col];
            if (num == -1) {
                minus++;
            } else if (num == 0) {
                zero++;
            } else {
                plus++;
            }
            return;
        }

        int newSize = size / 3;
        // 첫번째 행
        cutting(row, col, newSize);
        cutting(row, col + newSize, newSize);
        cutting(row, col + newSize * 2, newSize);
        // 두번째 행
        cutting(row + newSize, col, newSize);
        cutting(row + newSize, col + newSize, newSize);
        cutting(row + newSize, col + newSize * 2, newSize);
        // 세번째 행
        cutting(row + newSize * 2, col, newSize);
        cutting(row + newSize * 2, col + newSize, newSize);
        cutting(row + newSize * 2, col + newSize * 2, newSize);
    }


    static boolean isSame(int row, int col, int size) {
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

// S2 종이의 개수 분할 정복 재귀
// 색종이와 문제가 일치하다 로직도 같다
// 분할해서 9개라서 3으로 나누고 해당 인덱스마다 재귀해서 들어간다
// 색이 같은지에 대한 기저조건을 설정하고 숫자가 일치할 경우 맨앞숫자에 대한 변수의 값을 증가시키고
// 각 행마다 3분할로 나눈 영역을 재귀호출해서 isSame을 통과하고 숫자를 증가시킨다음 return 으로 탈출한다