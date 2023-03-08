package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuffer sb = new StringBuffer();
    for(int i=0; i<T; i++) {
      String s = br.readLine();
      int[] result = recursion(s, 0, s.length()-1, 1);
      sb.append(result[1] + " " + result[0]).append('\n');
    }
    System.out.println(sb);
  }
  public static int[] recursion(String s, int l, int r,int cnt){
    if(l >= r) {
      return new int[]{cnt,1};
    }
    else if(s.charAt(l) != s.charAt(r)) {
      return new int[]{cnt,0};
    }
    else return recursion(s, l+1, r-1, cnt + 1);
  }
}
