package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_17255 {
  static String N;
  static int answer = 0;
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = br.readLine();
    for(int i=0; i<N.length(); i++) {
      dfs(i, i, N.charAt(i)+"");
    }
    System.out.println(answer);
  }

  public static void dfs(int start, int end, String s) {
    if(start - 1 < 0 && end + 1 >= N.length()) {
      if(!set.contains(s))
        answer++;
      set.add(s);
      return;
    }
    
    if(start -1 >= 0) {
      dfs(start-1, end, s + N.charAt(start-1)+s);

    }
    if(end + 1 < N.length()) {
      dfs(start, end+1, s+s+N.charAt(end+1));

    }
  }
}
