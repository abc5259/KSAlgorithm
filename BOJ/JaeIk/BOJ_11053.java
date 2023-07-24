package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    static int[] seq;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        seq = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            LIS(i);
        }

        int max = dp[0];

        for(int i=1; i<n; i++){
            if(max<dp[i])max=dp[i];
        }

        System.out.println(max);
    }

    static int LIS(int n){
        if(dp[n]==null){
            dp[n]=1;

            for(int i=n-1; i>=0; i--){
                if(seq[n]>seq[i]){
                    //N보다 작은 i에 대해 LIS(i)의 값을 반환 받아 dp[N]=1보다 큰 값이 있으면 +1 후 갱신
                    dp[n] = Math.max(dp[n], LIS(i)+1);
                }
            }
        }
        return dp[n];
    }
}
