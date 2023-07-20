package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1463 {
    static Integer[] dp; //Integer형은 Int와 다르게 Null값을 가질 수 있음

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        //연산 결과가 0또는 1인 경우 0을 반환하도록 하기 위해 두 원소를 0으로 초기화해준다
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(dp(n));
    }

    //왜 n번째 원소에 저장할까 -> dp[0]또는 dp[1]의 초기값이 리턴되면 반환값+1이 상위함수의 dp[n]에 들어간다. 이 과정이 재귀적으로 일어나서 연산횟수를 구함
    static int dp(int n){
        if(dp[n] == null){
            if(n%6==0){
                dp[n] = Math.min(dp(n/2), Math.min(dp(n/3), dp(n-1)))+1;
            }
            else if(n%3==0){
                dp[n] = Math.min(dp(n/3), dp(n-1))+1;
            }
            else if(n%2==0){
                dp[n] = Math.min(dp(n/2), dp(n-1))+1;
            }
            else{
                dp[n] = dp(n-1)+1;
            }
        }

        return dp[n];
    }

}