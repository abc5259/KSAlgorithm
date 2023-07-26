package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25708 {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[] rowSum = new int[N];
        int[] colSum = new int[M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                rowSum[i] += map[i][j];
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                colSum[i] += map[j][i];
            }
        }


        int max = Integer.MIN_VALUE;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                for(int l=0; l<M-1; l++) {
                    for(int m=l+1; m<M; m++) {

                        int sum = rowSum[i] + rowSum[j] + colSum[l] + colSum[m]
                                - map[i][l] - map[i][m] - map[j][l] - map[j][m]
                                + (j - i - 1) * (m - l -1);

                        max = Math.max(max,sum);
                    }
                }
            }
        }

        System.out.println(max);
    }

}
