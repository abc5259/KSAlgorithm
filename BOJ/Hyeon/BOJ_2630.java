package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int blue, white;
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
        making(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void making(int row, int col, int size) {
        if (isColor(row, col, size)) {
            if (papers[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        int newSize = size / 2;
        making(row, col, newSize);
        making(row, col + newSize, newSize);
        making(row + newSize, col, newSize);
        making(row + newSize, col + newSize, newSize);
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

// S2 색종이 만들기 분할정복
// 4가지로 나누기 대문에 size를 나누기 2해서 열과 행 열 + 사이즈, 행 + 사이즈 이런식으로 분할한다
// 계속해서 분할하는데 기저사례는 모든 색종이의 색이 같을 때라서 isColor 메소드로 기저 조건을 설정한다
// 0,0 좌표부터 시작하고 N개의 사이즈이기에 0,0,N으로 시작한다.
// isColor해서 색이 같지 않으면 잘라야하기 때문에 사이즈를 나눠서 다시 4사분명의 재귀호출을 통해서
// 파랑이나 하얗을 추가하고 나서 재귀를 돌아오고 이를 반복한다.