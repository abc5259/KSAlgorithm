package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    while (T-- > 0) {
      String cmd = br.readLine();
      int N = Integer.parseInt(br.readLine());
      String arrStr = br.readLine();
      String[] arr = arrStr.substring(1, arrStr.length()-1).split(",");
      int left = 0;
      int right = N - 1;
      boolean isLeft = true;
      boolean isError = false;
      for(int i=0; i<cmd.length(); i++) {
        char c = cmd.charAt(i);
        if(c == 'R') {
          isLeft = !isLeft;
        }
        if(c == 'D') {
          if(isLeft) {
            left++;
          }else {
            right--;
          }
          // System.out.println("left = " + left + " rigjt = " + right);
          if(left > right + 1) { 
            isError = true;
            break;
          } 
        }
      }

      if(isError) {
        sb.append("error\n");
      }
      else if(left > right) {
        sb.append("[]\n");
      }
      else if(left == right) {
        sb.append("[").append(arr[left]).append("]\n");
      }
      else {
        sb.append("[");
        if(isLeft) {
          for(int i=left; i<right; i++) {
            sb.append(arr[i]).append(',');
          }
          sb.append(arr[right]).append(']').append('\n');
        }else {
          for(int i=right; i>left; i--) {
            sb.append(arr[i]).append(',');
          }
          sb.append(arr[left]).append(']').append('\n');
        }
      }
    }
    System.out.print(sb);
  }
}
