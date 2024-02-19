package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {
    static final int MOD = 10_007;
    static long[][] arr;
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        arr = new long[1001][10];
        for(int i=0; i<10; i++){
            arr[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= MOD;
                }
            }
        }

        long answer=0;
        for(int i=0; i<10; i++){
            answer += arr[n][i];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}