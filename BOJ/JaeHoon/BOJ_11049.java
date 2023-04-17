package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {
    static int N;
    static int R[] = new int[500];
    static int C[] = new int[500];
    static int[][] dp = new int[500][500];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        func(0,N-1);
        System.out.println(dp[0][N-1]);
    }

    public static int func(int x, int y) {
        if(y - x <= 0) return 0;

        if(dp[x][y] > 0) return dp[x][y];
        int min = Integer.MAX_VALUE;
        for(int k=x; k<y; k++) {
            min = Math.min(min, func(x,k) + func(k+1,y) + R[x] * C[k] * C[y]);
        }
        return dp[x][y]=min;
    }
}

