package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {
    static int[] dp = new int[1000001]; //배열 크기 왜?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<dp.length; i++){
            dp[i] = -1;
        }

        System.out.println(tile(n));

    }

    static int tile(int n){
        if(dp[n]==-1){
            //if문에서 바로 return해주는것과의 차이는? -> 메모이제이션
            dp[n] = (tile(n-1) + tile(n-2))%15746;
        }
        return dp[n];
    }
}
