package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] ab = br.readLine().split(" ");
                score[i][0] = Integer.parseInt(ab[0]);
                score[i][1] = Integer.parseInt(ab[1]);
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    
                }
            }
        }

    }
}
