package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_1701 {
  static String s;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();

    int low = 0;
    int high = s.length();
    while (low + 1 < high) {
      int mid = (low + high) / 2;
      if(check(mid)) {
        low = mid;
      }else {
        high = mid;
      }
    }

    System.out.println(low);
  }

  public static boolean check(int len) {
      if(len == 0) return true;
      Set<String> set = new HashSet<>();
      for(int i=0; i<s.length(); i++) {
        if(i+len > s.length()) continue;
          StringBuilder sb = new StringBuilder();
          for(int j=i; j<i+len; j++) sb.append(s.charAt(j));
          if(set.contains(sb.toString())) {
            return true;
          }
          set.add(sb.toString());
      }
      return false;
  }
}
