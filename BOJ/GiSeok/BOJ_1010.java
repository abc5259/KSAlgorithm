/*
백준 - 1010 다리 놓기 (05/23 월)

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tcase = Integer.parseInt(br.readLine());
        int[][] dp = new int[32][32];
        int[][] NM = new int[tcase][2];
        for (int i = 1; i < 31 + 1; i++)
                dp[1][i] = i;
        
        int maxN = 0;
        int maxM = 0;
        for (int cnt = 0; cnt < tcase; cnt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            NM[cnt][0] = N;
            NM[cnt][1] = M;
            
            if (maxN < N)
                maxN = N;
            if (maxM < M)
                maxM = M;
        }

        for (int i = 2; i < maxN + 1; i++) {
            for (int j = i; j < maxM + 1; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        
        for (int i = 0; i < tcase; i++) {
            System.out.println(dp[NM[i][0]][NM[i][1]]);
        }
    }
}