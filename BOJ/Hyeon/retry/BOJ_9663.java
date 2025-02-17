package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int N;
    static int[] rowColumns;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;

        rowColumns = new int[N];
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        // 꽉 채운 행일 경우 cnt 증가하고 종료
        if (row == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            rowColumns[row] = i;
            // 놓을 수 있는 위치일 경우 재귀
            if (check(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            // row의 행과 이전의 행에서 같은 열을 가지는 경우
            if (rowColumns[i] == rowColumns[row]) {
                return false;
            }
            // 열의 차와 행의 차가 같으면 대각선
            else if (row - i == Math.abs(rowColumns[i] - rowColumns[row])) {
                return false;
            }
        }
        return true;
    }
}
// G4 N-Queen DFS + 백트래킹
// 퀸을 절대 못놓는 자리를 판별하는 유망함수 check를 구성하여서 만든다.
// 각 행당 각 열당 1개의 퀸만 놓을 수 있기 때문에
// 이를 활용하여 재귀함수를 탈출시키는 입력행의 열값과 이전 행들에서 중복되는 열값이 있을 경우 와
// 해당 행과 이전 행의 차와 행의 값과 이전 행의 값의 차가 같을 경우 대각선임을 제외하고
// 재귀해서 계산한다.