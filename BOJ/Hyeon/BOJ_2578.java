package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
    private static int[][] bingo;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        bingo = new int[5][5];
        visit = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ans++;
                check(Integer.parseInt(st.nextToken()));
                if (cntBingo() >= 3) {
                    System.out.println(ans);
                    return;
                }
            }
        }
    }

    static void check(int num) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    visit[i][j] = true;
                }
            }
        }
    }

    static int cntBingo() {
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (visit[i][j]) {
                    tmp++;
                }
            }
            if (tmp == 5) {
                cnt++;
            }
        }
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (visit[j][i]) {
                    tmp++;
                }
            }
            if (tmp == 5) {
                cnt++;
            }
        }
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (visit[i][i]) {
                tmp++;
            }
        }
        if (tmp == 5) {
            cnt++;
        }
        tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (visit[4 - i][i]) {
                tmp++;
            }
        }
        if (tmp == 5) {
            cnt++;
        }
        return cnt;
    }
}
// S4 빙고 시뮬레이션
// 일단 그냥 풀었다 체크하는거랑 검사하는거랑 로직을 나눠서 감당했고.
// cnt를 개선하는 거에 있어서 전역으로 빼지않고 그냥 파라미터로 변경했다.
// check랑 cntBingo로 역할을 나눴다.