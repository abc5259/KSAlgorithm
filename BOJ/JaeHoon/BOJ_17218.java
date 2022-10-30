package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17218 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    String[][] dp = new String[s1.length()][s2.length()];
    boolean check = false;
    for(int i=0; i<s1.length(); i++)
      Arrays.fill(dp[i], "");
    
    for(int i=0; i<s1.length(); i++) {
      if(s1.charAt(i) == s2.charAt(0) || check) {
        dp[i][0] = s2.charAt(0) + "";
        check = true;
      }
    }
    // for(int i=0; i<s1.length(); i++)
    //   System.out.println(Arrays.toString(dp[i]));
    check = false;
    // System.out.println();
    for(int i=0; i<s2.length(); i++) {
      if(s2.charAt(i) == s1.charAt(0) || check) {
        dp[0][i] = s1.charAt(0)+ "";
        check = true;
      }
    }
    // for(int i=0; i<s1.length(); i++)
    //   System.out.println(Arrays.toString(dp[i]));
    for(int i=1; i<s1.length(); i++) {
      for(int j=1; j<s2.length(); j++) {
        if(s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = dp[i-1][j-1] + s1.charAt(i);
        }
        else {
          if(dp[i-1][j].length() < dp[i][j-1].length()) 
            dp[i][j] = dp[i][j-1];
          else 
            dp[i][j] = dp[i-1][j];
        }
      }
    }
    // System.out.println();
    // for(int i=0; i<s1.length(); i++)
    //   System.out.println(Arrays.toString(dp[i]));
    System.out.println(dp[s1.length()-1][s2.length() -1]);
  }
}
