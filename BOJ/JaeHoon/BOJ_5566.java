package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5566 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] board = new int[N+1];
    for(int i=1; i<=N; i++) {
      board[i] = Integer.parseInt(br.readLine());
    }
    int[] dice = new int[M+1];
    for(int i=1; i<=M; i++) {
      dice[i] = Integer.parseInt(br.readLine());
    }
    int currIdx = 1;
    int answer = 1;
    for(int i=1; i<=M; i++) {
      currIdx += dice[i];
      if(currIdx >= N) {
        answer = i;
        break;
      }
      currIdx += board[currIdx];
      if(currIdx >= N) {
        answer = i;
        break;
      }
    }
    System.out.println(answer);
  }
}
