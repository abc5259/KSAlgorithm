package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2565 {
    static int n;
    static int[][] wire;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        wire = new int[n][n];
        dp = new Integer[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            //왜 i와 와이어인덱스의 자리를 바꾸면 답이 다르게나올까
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, recur(i));
        }

        System.out.println(n-max);

    }

    static int recur(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for(int i=n+1; i< wire.length; i++){
                if(wire[n][1] < wire[i][1]){
                    dp[n] = Math.max(dp[n], recur(i)+1);
                }
            }
        }
        return dp[n];
    }
}
