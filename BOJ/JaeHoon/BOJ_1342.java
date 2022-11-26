package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1342 {
  static String candidate = "";
  static char[] s;
  static int answer;
  static int[] alpha = new int[26];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine().toCharArray();
    for(int i=0; i<s.length; i++)
      alpha[s[i] - 'a']++; 
    solve(0, s.length,-1);
    System.out.println(answer);
  }
  public static void solve(int depth, int N,int prev) {
    if(depth == N) {
      answer++;
      return;
    }
    for(int i=0; i<26; i++) {
      if(alpha[i] > 0 && prev != i) {
        alpha[i]--;
        s[depth] = (char)('a' + i);
        solve(depth+1,N,i);
        alpha[i]++;
      }
    }
  }
}
