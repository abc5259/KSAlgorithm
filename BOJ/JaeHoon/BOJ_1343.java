package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1343 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuffer sb = new StringBuffer();
    int cnt = 0;
    boolean check = true;
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) == '.') {
        if(cnt > 0) {
          int aCnt = cnt / 4;
          int bCnt = (cnt % 4) / 2;
          if(aCnt * 4 + bCnt * 2 != cnt) {
            check = false;
            break;
          }
          for(int c=1; c<=aCnt; c++) sb.append("AAAA");
          for(int c=1; c<=bCnt; c++) sb.append("BB");
        }
        cnt = 0;
        sb.append(".");
      }
      else if(str.charAt(i) == 'X') {
        cnt++;
      }
    }

    if(cnt > 0) {
      int aCnt = cnt / 4;
      int bCnt = (cnt % 4) / 2;
      if(aCnt * 4 + bCnt * 2 != cnt) {
        check = false;
      }
      for(int c=1; c<=aCnt; c++) sb.append("AAAA");
      for(int c=1; c<=bCnt; c++) sb.append("BB");
    }

    if(check) System.out.println(sb);
    else System.out.println(-1);
  }
}
