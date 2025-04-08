package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] topNi = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                topNi[i][j] = charArray[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            doGear(num, dir);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += Math.pow(2, i) * topNi[i][0];
        }
        System.out.print(score);
    }

    static void doGear(int idx, int dir) {
        leftSpin(idx - 1, -dir);
        rightSpin(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void leftSpin(int idx, int dir) {
        if (idx < 0) {
            return;
        }
        if (topNi[idx][2] == topNi[idx + 1][6]) {
            return;
        }
        leftSpin(idx - 1, -dir);
        rotate(idx, dir);
    }

    static void rightSpin(int idx, int dir) {
        if (idx > 3) {
            return;
        }
        if (topNi[idx][6] == topNi[idx - 1][2]) {
            return;
        }

        rightSpin(idx + 1, -dir);
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
            for (int i = 1; i < 7; i++) {
                topNi[idx][i] = topNi[idx][i + 1];
            }
            topNi[idx][7] = tmp;
        }
    }
}

//