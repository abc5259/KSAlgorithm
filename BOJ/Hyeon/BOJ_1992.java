package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static int[][] quad;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        quad = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                quad[i][j] = str.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        compress(0, 0, N);

        System.out.print(sb);
    }

    static void compress(int row, int col, int size) {
        if (isSame(row, col, size)) {
            sb.append(quad[row][col]);
            return;
        } else {
            if (size == 1) {
                for (int i = row; i < row + size; i++) {
                    for (int j = col; j < col + size; j++) {
                        sb.append(quad[i][j]);
                    }
                }
                return;
            } else {
                sb.append("(");
            }
        }
        int divSize = size / 2;

        compress(row, col, divSize);
        compress(row, col + divSize, divSize);
        compress(row + divSize, col, divSize);
        compress(row + divSize, col + divSize, divSize);
        sb.append(")");
    }

    static boolean isSame(int row, int col, int size) {
        int tmp = quad[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (tmp != quad[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// S1 쿼드트리 분할정복
// 일단 어제 푼 색종이와 접근은 비슷하다 2로 나눠서 각 좌표마다 4개의 분할을 통해서 계속해서 분할하고
// size가 1이되면 정복해서 합친다.
// 일단 로직자체가 선택된 영역이 모두 같은 숫자인지를 판단하는 isSame 메소드를 통해 분기한다
// 이때 compress 라는 재귀 호출 메소드는 row와 col의 좌표를 가지고 size를 줄이면서 반복한다
// isSame을 통해서 틀릴경우 ( 괄호를 열고 size를 2로 나눠서 분할한다
// 계속해서 분할되다가 isSame을 통해 참일경우와 isSame이 거짓임에도 size가 1일경우 숫자를 출력해야한다
// 참이면 숫자하나만 출력하고 4개의 분할에서 마지막 사분면의 분할 마저 끝날 때마다 ( 괄호를 붙여서 해당 분할을 마감한다고 생각하면된다.
// 그래서 괄호 열고 size가 1이거나 참일 때 숫자를 주고 )닫는걸 반복하고
// 압축된 메소드는 각 좌표 size를 더해서 1,2,3,4분면마다 분할 정복을 거친다.