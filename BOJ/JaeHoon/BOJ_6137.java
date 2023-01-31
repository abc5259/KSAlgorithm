package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6137 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    char[] S = new char[N];
    for(int i=0; i<N; i++) {
      S[i] = br.readLine().charAt(0);
    }

    StringBuffer sb = new StringBuffer(N);

    int start = 0;
    int end = N-1;
    int cnt = 0;
    while(start <= end) {
      if(cnt > 0 && cnt % 80 == 0) sb.append('\n');
      if(S[start] < S[end]) {
        sb.append(S[start++]);
      }
      else if(S[start] > S[end]) {
        sb.append(S[end--]);
      }
      else { 
        int tempStart = start;
        int tempEnd = end;

        while(S[tempStart] == S[tempEnd]) {
          tempStart++;
          tempEnd--;
          if(tempStart >= tempEnd) {
            sb.append(S[start++]);
            break;
          }
          if(S[tempStart] < S[tempEnd]) {
            sb.append(S[start++]);
          }
          else if(S[tempStart] > S[tempEnd]) {
            sb.append(S[end--]);
          }
        }
      }
      cnt++;
    }
    System.out.println(sb);
  }
}
