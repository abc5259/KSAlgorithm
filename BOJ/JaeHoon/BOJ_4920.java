package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = solve(map,N);
            cnt++;
            sb.append(cnt + ". ").append(result+"\n");
        }
        System.out.println(sb);
    }
    public static int solve(int[][] map, int N) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(j + 3 < N) {
                    int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    max = Math.max(max,sum);
                }

                if(i + 3 < N) {
                    int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    max = Math.max(max,sum);
                }

                if(i+1 < N && j+2 < N) {
                    int sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                    max = Math.max(max,sum);
                }

                if(i+2 < N && j-1 >= 0) {
                    int sum = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+2][j-1];
                    max = Math.max(max,sum);

                    sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j-1];
                    max = Math.max(max,sum);
                }

                if(i+2 < N && j+1 < N) {
                    int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                    max = Math.max(max,sum);

                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    max = Math.max(max,sum);
                }

                if(i + 1 < N && j-1 >= 0 && j+1 < N) {
                    int sum = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+1][j+1];
                    max = Math.max(max,sum);
                }

                if(i-1 >= 0 && i+1 < N && j+1 < N) {
                    int sum = map[i][j] + map[i-1][j+1] + map[i][j+1] + map[i+1][j+1];
                    max = Math.max(max,sum);
                }

                if(i+1 < N && j+1 < N) {
                    int sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }
}
