package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
    static int[][] puzzle;
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        puzzle = new int[9][9];
        // 1. 9 x 9 배열의 스도쿠를 만든다.

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 스도쿠에 입력값을 넣는다.

        dfs(0);
        // 3. 스도쿠를 dfs 탐색하여 스도쿠의 첫칸부터 계속해서 dfs하여 스도쿠를 만족하는 값에 가거나 백트래킹한다.
        // 첫칸은 0칸 마지막칸은 80칸 0~80칸을 채우고 81이 되면 리턴된다.

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(puzzle[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        // 4. 스도쿠를 출력한다.
    }

    static void dfs(int num) {
        if (num == 81) {
            finish = true;
            return;
        }
        // dfs 탈출 조건
        // dfs 깊게 가서 무사히 81까지 도달했으면 finish 를 통해 재귀로 돌아가서 바로 탈출

        int y = num / 9;
        int x = num % 9;

        // 현재 입력값으로 행과 열을 만든다.

        if (puzzle[y][x] != 0) {
            dfs(num + 1);
            // 이미 수가 있으면 다음 dfs를 반복해서 지나간다.
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(y, x, i)) {
                    // 행과 열 3 x 3을 검사하는 메소드
                    puzzle[y][x] = i;
                    // 참일 경우 i값을 대입하고
                    dfs(num + 1);
                    // 다음 열로 지나가고 다음열로 갔을 때
                    if (finish) {
                        return;
                    }
                    // 끝까지 도달해서 기저조건인 true 받으면 여기서 탈출
                    puzzle[y][x] = 0;
                    // 만약 못도달하면 0으로 돼서 다음 i랑 비교
                }
            }
        }
    }

    static boolean isValid(int y, int x, int value) {
        // 1~9까지 수를 대입해서
        for (int i = 0; i < 9; i++) {
            if (puzzle[y][i] == value || puzzle[i][x] == value) {
                return false;
            }
        }
        // 행과 열을 비교하고나서

        int dy = y / 3 * 3;
        int dx = x / 3 * 3;

        for (int i = dy; i < dy + 3; i++) {
            for (int j = dx; j < dx + 3; j++) {
                if (puzzle[i][j] == value) {
                    return false;
                }
            }
        }
        // 대각선을 비교한다.
        return true;
    }
}

// G4 스도쿠 백트래킹
// 입력값으로 0,0의 자리인 0을 넣고 해당 자리를 80까지 계산하여 /9 %9로 행과 열을 구한다.
// 그리고 그 행과 열에서 값이 이미 0말고 다른 수가 있으면, 다음 dfs로 넘어간다.== num +1
// 수가 없으면 1~9까지 대입하고 isvalid의 메소드를 통해서 행과 열, 대각선을 점검한다.
// 참일 경우 해당 퍼즐에 값을 대입하고 다음 dfs ( num + 1 ) 로 간다.
// 이게 끝 깊이 까지 갔으면 return값으로 true를 가져오고, 없으면 = 0을 대입해서 반복문을 다시돌려 다른 1~9를 대입한다.