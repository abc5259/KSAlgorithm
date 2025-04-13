package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15662 {
    static int T;
    static int[][] topNi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        topNi = new int[T][8];

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                topNi[i][j] = str.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            gearOp(idx, dir);
        }
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (topNi[i][0] == 1) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    static void gearOp(int idx, int dir) {
        leftGear(idx - 1, -dir);
        rightGear(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void leftGear(int idx, int dir) {
        if (idx < 0) {
            return;
        }
        if (topNi[idx][2] == topNi[idx + 1][6]) {
            return;
        }
        leftGear(idx - 1, -dir);
        rotate(idx, dir);
    }

    static void rightGear(int idx, int dir) {
        if (idx > T - 1) {
            return;
        }
        if (topNi[idx][6] == topNi[idx - 1][2]) {
            return;
        }
        rightGear(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void rotate(int idx, int dir) {
        if (dir == 1) {
            int tmp = topNi[idx][7];
            for (int i = 7; i > 0; i--) {
                topNi[idx][i] = topNi[idx][i - 1];
            }
            topNi[idx][0] = tmp;
        } else {
            int tmp = topNi[idx][0];
            for (int i = 0; i < 7; i++) {
                topNi[idx][i] = topNi[idx][i + 1];
            }
            topNi[idx][7] = tmp;
        }
    }
}

// G5 톱니바퀴 2 시뮬레이션
// 톱니 바퀴 1을 참고하여서 풀었다 left 와 right 로 사이드를 나누고 rotate 분리해서 돌아게 했다.