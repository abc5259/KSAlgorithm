package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(recur(a ,b ,c)).append('\n');

        }

        System.out.println(sb);
    }

    static boolean checkRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

    static int recur(int a, int b, int c){
        if(checkRange(a,b,c) && dp[a][b][c]!=0)return dp[a][b][c];

        if(a<=0 || b<=0 || c<=0)return 1;

        if(a>20 || b>20 || c>20)return dp[20][20][20] = recur(20,20,20);

        if(a<b && b<c)return dp[a][b][c] = recur(a,b,c-1) + recur(a,b-1,c-1) - recur(a,b-1,c);

        return dp[a][b][c] =  recur(a-1,b,c) + recur(a-1,b-1,c) + recur(a-1,b,c-1) - recur(a-1,b-1,c-1);
    }
}
