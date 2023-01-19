package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719 {
  static boolean[] isUsed;
  static String str;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str = br.readLine();
  
    isUsed = new boolean[str.length()];
    solve(0, str.length()-1);
    System.out.println(sb);
  }
  public static void solve(int start, int end) {
    if(start > end || end >= str.length()) return;
    int mini = Integer.MAX_VALUE; 
    int idx = -1;
    for(int i=start; i<=end; i++) {
      if(!isUsed[i] && str.charAt(i) < mini) {
        mini = str.charAt(i);
        idx = i;
      }
    }

    if(mini == Integer.MAX_VALUE) return;

    isUsed[idx] = true;
    String s = "";
    for(int i=0; i<str.length(); i++) {
      if(isUsed[i]) s+= str.charAt(i);
    }
    sb.append(s+"\n");

    solve(idx+1, end);
    solve(start, idx-1);
  }
}
