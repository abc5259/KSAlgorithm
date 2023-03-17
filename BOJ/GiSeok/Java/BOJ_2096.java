package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lines = new int[3];
        int[][] tmpDp = new int[2][3];
        int[] minDp = new int[3];
        int[] maxDp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                lines[j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    tmpDp[0][j] = lines[j];
                    tmpDp[1][j] = lines[j];
                }
            }

            if (i != 0) {
                minDp[0] = Math.min(tmpDp[0][0] + lines[0], tmpDp[0][1] + lines[0]);
                maxDp[0] = Math.max(tmpDp[1][0] + lines[0], tmpDp[1][1] + lines[0]);

                minDp[2] = Math.min(tmpDp[0][1] + lines[2], tmpDp[0][2] + lines[2]);
                maxDp[2] = Math.max(tmpDp[1][1] + lines[2], tmpDp[1][2] + lines[2]);

                minDp[1] = Math.min(tmpDp[0][0] + lines[1], tmpDp[0][1] + lines[1]);
                minDp[1] = Math.min(tmpDp[0][2] + lines[1], minDp[1]);
                maxDp[1] = Math.max(tmpDp[1][0] + lines[1], tmpDp[1][1] + lines[1]);
                maxDp[1] = Math.max(tmpDp[1][2] + lines[1], maxDp[1]);

                for (int c = 0; c < 3; c++) {
                    tmpDp[0][c] = minDp[c];
                    tmpDp[1][c] = maxDp[c];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            if (min > tmpDp[0][i])
                min = tmpDp[0][i];
            if (max < tmpDp[1][i])
                max = tmpDp[1][i];
        }
        
        System.out.println(max + " " + min);
    }
}
