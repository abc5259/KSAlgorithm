package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    static int[] seq;
    static Integer[] r_dp;
    static Integer[] l_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        r_dp = new Integer[n];
        l_dp = new Integer[n];
        seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(r_dp[i]+l_dp[i], max);
        }
        System.out.println(max-1);

    }

    static int LIS(int n){
        if(r_dp[n]==null){
            r_dp[n]=1;

            for(int i=n; i>=0; i--){
                if(seq[n]>seq[i]){
                    r_dp[n] = Math.max(r_dp[n], LIS(i)+1);
                }
            }
        }
        return r_dp[n];
    }

    static int LDS(int n){
        if(l_dp[n]==null){
            l_dp[n]=1;
            // N 이후의 노드들을 탐색
            // 이후의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
            for(int i=n+1; i<l_dp.length; i++){
                if(seq[n]>seq[i]){
                    l_dp[n] = Math.max(l_dp[n], LDS(i)+1);
                }
            }
        }
        return l_dp[n];
    }
}
