package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int[][] sum = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int h=1; h<=N-i+1; h++) {
                    for(int w=1; w<=M-j+1; w++) {
                        int[] end = {i+h-1, j+w-1};

                        int s = sum[end[0]][end[1]] - sum[end[0]][end[1] - j] - sum[end[0] - i][end[1]] + sum[end[0] - i][end[1] - j];
                        max = Math.max(max, s);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
