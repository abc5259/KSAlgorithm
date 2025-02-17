package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int N;
    static int[] rowColumns; // rowColumns[2] = 4 <<< 2번 row에 현재 놓은 값이 4
    static boolean[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        rowColumns = new int[N]; // 열값

        dfs(0);
        System.out.println(cnt);
    }

    static int cnt;

    static void dfs(int row) {
        if (row == N) {
            cnt++;
            return;
        }
        // 현재 row 행에 Queen 을 놓아본다.
        // 옆으로 Column에 한자리 놓아본다
        for (int i = 0; i < N; i++) {
            rowColumns[row] = i;
            // 유망함수 하나 만든다.
            if (check(row)) {
                dfs(row + 1);
            }
        }
    }

    // 현재 row에 rowColumns에 저장된 이전 row의 퀸 자리 포함해서 여부 확인

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            // 세로로 겹치는지
            if (rowColumns[i] == rowColumns[row]) {
                return false;
            }
            // 대각선으로 겹치는 지
            else if (Math.abs(rowColumns[i] - rowColumns[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
