package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
  static String s1;
  static String s2;
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s1 = br.readLine();
    s2 = br.readLine();
    dp = new int[s1.length()+1][s2.length()+1];
    
    for(int i=1; i<=s1.length(); i++) {
      for(int j=1; j<=s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) 
          dp[i][j] = dp[i-1][j-1] + 1;
        
        dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j], dp[i][j-1]));
      } 
    }
    System.out.println(dp[s1.length()][s2.length()]);
  }
  
}
