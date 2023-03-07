package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
  static int min = Integer.MAX_VALUE; 
  static int max = Integer.MIN_VALUE; 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    solve(new StringBuffer(s),0);
    System.out.println(min + " " + max);
  }
  public static void solve(StringBuffer str, int total) {
    if(str.length() == 1) { // 총길이가 1이라면
      int n = str.charAt(0) - '0';
      if(n % 2 == 1) total++;
      max = Math.max(max, total);
      min = Math.min(min, total);
      return;
    }

    if(str.length() == 2) { //총길이가 2라면 
      int n1 = str.charAt(0) - '0';
      int n2 = str.charAt(1) - '0';
      if(n1 % 2 == 1) total++;
      if(n2 % 2 == 1) total++;
      solve(new StringBuffer(String.valueOf(n1+n2)),total);
      return;
    }

    for(int i=0; i<str.length(); i++) {
      if((str.charAt(i) - '0') % 2 == 1) total++;
    }

    // 총 길이가 3이라면 
    for(int i=1; i<=str.length() - 2; i++) {
      for(int j=i+1; j<=str.length() - 1; j++) {
        int n1 = Integer.parseInt(str.substring(0,i));
        int n2 = Integer.parseInt(str.substring(i,j));
        int n3 = Integer.parseInt(str.substring(j,str.length()));
        solve(new StringBuffer(String.valueOf(n1+n2+n3)),total);
      }
    }
    
  }
}
