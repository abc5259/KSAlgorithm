package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16917 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int need = Math.min(X, Y);
    int add = Math.max(X, Y) - need;
    int answer = 0;
    if(C * need * 2 < A * need + B * need) {
      answer = C * need * 2;
    }else {
      answer = A * need + B * need;
    }

    if(add != 0) {
      if(X > Y) {
        if(A*add < C*add*2)
          answer += A * add;
        else 
          answer += C*add*2;
      }else {
        if(B*add < C*add*2)
          answer += B * add;
        else 
          answer += C*add*2;
      }
    }
    System.out.println(answer);
  }
}
