package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class BOJ_9251 {
        static char[] a;
        static char[] b;
        static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        dp = new Integer[a.length][b.length];

        System.out.println(lcs(a.length-1, b.length-1));
    }

    static int lcs(int x, int y){
        if(x==-1||y==-1){
            //왜 return 0이지? -> 배열의 처음에 도달할 때 함수의 반환값으로 0을 반환하고 +1을해서 결과가 도출됨
            return 0;
        }

        if(dp[x][y]==null){
            dp[x][y] = 0;

            if(a[x]==b[y]){
                //두 값이 같으면 이전 원소들로 이어서 탐색하고 그 함수의 반환값에 +1을 해서 카윤트해준다
                dp[x][y] = lcs(x-1, y-1) + 1;
            }
            else{
                //두 값이 같지 않을 때 새로 탐색한다
                dp[x][y] = Math.max(lcs(x-1,y), lcs(x,y-1));
            }
        }
        return dp[x][y];
    }


}
