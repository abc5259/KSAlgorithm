package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10942_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) dp[i][i] = 1;
        for (int i = 1; i < n; i++) dp[i][i+1] = a[i] == a[i+1] ? 1 : 0;

        for (int size = 2; size <= n-1; size++) {
            for (int i = 1; i <= n-size; i++) {
                dp[i][i+size] = (a[i] == a[i+size] && dp[i+1][i+size-1] == 1) ? 1 : 0;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
        }

        bw.flush(); bw.close();
    }
}
