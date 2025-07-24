package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14938 {

    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //지역의 개수
        M = Integer.parseInt(st.nextToken());  //수색범위
        R = Integer.parseInt(st.nextToken());  //길의 개수
        int[] item = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) arr[i][j] = 0;
                else arr[i][j] = 10000000;
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
            arr[b][a] = c;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == k || j == k || i == j) continue;
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] <= M) {
                    total += item[j];
                }
            }
            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}
