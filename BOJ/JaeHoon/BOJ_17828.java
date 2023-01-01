package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17828 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    
    StringBuffer sb = new StringBuffer();
    if(1*N <= X && 26*N >= X) {
      char[] answer = new char[N];
      for(int i=0; i<N; i++)
        answer[i] = 'A';
      X-=N;
      for(int i=N-1; i>=0 && X > 0; i--) {
        int temp = Math.min(X, 25);
        answer[i] += temp;
        X -= temp;
      }
      for(int i=0; i<N; i++)
        sb.append(answer[i]);
      System.out.println(sb);
      
    }else { 
      System.out.println("!");
    }
  }
}
