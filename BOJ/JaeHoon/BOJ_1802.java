package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1802 {
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine());

    
    StringBuffer sb = new StringBuffer();
    solve("1",2);
    solve("0",2);
    set.add("1");
    set.add("0");
    while(T > 0) {   
      String s = br.readLine();
      sb.append(set.contains(s) ? "YES" : "NO").append('\n');
      T--;
    }
    System.out.println(sb);
  }

  public static void solve(String str, int depth) {
    String s1 = "1";
    String s2 = "0";
    int newStrLength = (int)Math.pow(2, depth) - 1;
    StringBuffer newStr1 = new StringBuffer(newStrLength);
    StringBuffer newStr2 = new StringBuffer(newStrLength);
    newStr1.append("1");
    newStr2.append("0");
    if(newStrLength > 3000) return;
    int index = 0;
    for(int i=1; i<newStrLength; i++) {
      if(i % 2 == 0) {
        newStr1.append(s2);
        newStr2.append(s1);
        
        if(s1.equals("1"))
          s1 = "0";
        else 
          s1 = "1";

        if(s2.equals("1"))
          s2 = "0";
        else 
          s2 = "1";
      }else {
        newStr1.append(str.charAt(index));
        newStr2.append(str.charAt(index));
        index++;
      }
    }
    set.add(newStr1.toString());
    set.add(newStr2.toString());

    solve(newStr1.toString(), depth+1);
    solve(newStr2.toString(), depth+1);
  }
}
