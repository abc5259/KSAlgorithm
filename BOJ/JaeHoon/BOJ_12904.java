package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();
    while(T.length() != S.length()) {
      char c = T.charAt(T.length()-1);
      if(c == 'A') {
        T = T.substring(0, T.length() - 1);
      }
      if(c == 'B') {
        T = T.substring(0, T.length() - 1);
        String s = "";
        for(int i=T.length()-1; i>=0; i--) {
          s += T.charAt(i);
        }
        T = s;
      }
    }
    System.out.println(S.equals(T) ? 1 : 0);
  }
}

// S -> T 
// AB -> ABA
// AB -> BA -> BAB
// BAAA
// AB -> ABBB
// BAB
// ABBB