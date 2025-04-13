package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] topNi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        topNi = new int[4][8];
        for (int i = 0; i < 4; i++) {
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

        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += topNi[i][0] * (int) Math.pow(2, i);
        }
        System.out.print(score);
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
        if (idx > 3) {
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

// G5 톱니바퀴 시뮬레이션
// 아 일단 rotate 를 구현하는 방법 중에 한칸씩 밀어서 삽입하는 구조로 했다
// reverse 를 3번 쓰고 swap은 코드가 너무 길어질 거 같아서 안썻고
// left로 가고 right 로 가는것을 메소드로 분리해서 재귀를 동작시켰다.
// 그리고 중복 rotate 되지 않게 하기 위해였다.