package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] answer = new int[M][M];
        for(int i=0; i<M; i++) {
            Arrays.fill(answer[i],1);
        }
        for(int d=0; d<N; d++) {
            st = new StringTokenizer(br.readLine());
            int[] up = new int[3];
            for(int i=0; i<3; i++) {
                up[i] = Integer.parseInt(st.nextToken());
            }

//            int[][] grow = new int[M][M];

            int index = 0;
            for(int i=M-1; i>=0; i--) {
                while (up[index] == 0) {
                    index++;
                }
                answer[i][0] += index;
                up[index]--;
            }

            for(int i=1; i<M; i++) {
                while (up[index] == 0) {
                    index++;
                }
                answer[0][i] += index;
                up[index]--;
            }
        }
        for(int i=1; i<M; i++) {
            for(int j=1; j<M; j++) {
                answer[i][j] = Math.max(answer[i][j-1], Math.max(answer[i-1][j-1], answer[i-1][j]));
            }
        }
        print(answer);
    }


    public static void print(int[][] answer) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
