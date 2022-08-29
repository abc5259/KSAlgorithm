package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    if(getLength(N) >= k) {
      int low = 1;
      int high = N;
      while(low < high) {
        int middle = (low+high)/2;
        if(getLength(middle) < k) {
          low = middle+1;
        }else {
          high = middle;
        }
      }
      int idx = (int)((getLength(low)) % k);
      String num = String.valueOf(low);
      System.out.println(num.charAt(num.length() - 1 - idx));
    }else {
      System.out.println(-1);
    }
  }
  public static int getLength(int num) {
    Long curr = 10L;
    int currLength = 1;
    int length = 0;
    while(true) {
      if(num >= curr) {
        length += (curr-curr/10)*currLength;
        curr *= 10;
        currLength++;
      }else {
        length += (num - curr/10 + 1)*currLength;
        break;
      }
    }
    return length;
  }
}

      // 900 >= 10
      // length += 9
      // 900 >= 100
      // length += 90
      // 900 < 1000
      // length += 100 ~ 900 