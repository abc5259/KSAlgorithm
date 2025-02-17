package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239 {
    static int[][] puzzle; // 스도쿠를 의미하는 9 * 9 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        puzzle = new int[9][9];
        // 퍼즐 초기화

        String str;
        for (int i = 0; i < 9; i++) {
            str = br.readLine();
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = str.charAt(j) - '0';
            }
        }
        // 퍼즐 입력

        dfs(0);
        // dfs 실행 백트래킹
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(puzzle[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean finish;
    // 스도쿠를 다 완성했으면 탈출하는 플래그

    static void dfs(int num) {
        if (num == 81) {
            finish = true;
            return;
        }
        // 스도쿠 완성했을 때

        int row = num / 9;
        int col = num % 9;
        // 행과 열 변수로 num이라는 값이 81번째까지 가는데 그때까지의 div 연산은 행 mod 연산은 열이다.

        if (puzzle[row][col] != 0) {
            dfs(num + 1);
            // 이건 0이 아닌 다른 숫자가 스도쿠에 있으면 다음꺼로 넘어감.
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, col, i)) {
                    // 유효성 검사 메소드
                    // 해당 행 열일 때 i 값이 세로행에도 가로 열에도 3 * 3 퍼즐에도 없어야 하니까 있으면 false 반환

                    puzzle[row][col] = i;
                    // i 는 퍼즐에 넣고 다음꺼로 재귀
                    dfs(num + 1);
                    // 스도쿠 완성한 채로 재귀가 끝나서 나오면 이때 리턴받고
                    if (finish) {
                        return;
                    }
                    puzzle[row][col] = 0;
                    // 아니면 백 트래킹
                }
            }
        }
    }

    static boolean isValid(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[y][i] == num || puzzle[i][x] == num) {
                return false;
            }
        }
        // 세로 행과 가로 열에 같은 값있는지 탐색
        int y3 = y / 3 * 3;
        int x3 = x / 3 * 3; // 3 * 3 으로 탐색할 때 시작 정점 찾기

        for (int i = y3; i < y3 + 3; i++) {
            for (int j = x3; j < x3 + 3; j++) {
                if (puzzle[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}

// G4 스도쿠 백트래킹
// 어렵게 풀었다.
// 생각할게 많았다. 일단 조건으로는 작은 스도쿠의 수를 반환한다? 이는 1부터 삽입해서 dfs 백트래킹 문제임을 알 수 있다.
// 더해서 조건으로는 스도쿠이기에 세로 행과 가로열 3 * 3 퍼즐속에 입력하는 정수가 있으면 안돼서
// 이를 판별하는 메소드를 만들고
// 0이 아닌 수면 다음 수로 넘어가고 0이면 유효성 검사해서
// 퍼즐에 넣고 재귀하고 81번째까지 재귀하고 왔으면 플래그를 리턴받아서 탈출하는 과정이다.