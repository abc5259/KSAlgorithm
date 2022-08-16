package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int team = 0;
    while(N - 2 >= 0 && M -1 >= 0) {
      N -= 2;
      M -= 1;
      team++;
    } 
    while(K > 0) {
      if(N > 0) {
        N--;
        K--;
      }
      else if(M > 0) {
        M--;
        K--;
      }
      else {
        team--;
        N += 2;
        M += 1;
      }
    }
    System.out.println(team);
  }
}

// 여 2 남 1 팀
// K명은 인턴쉽 가야함 -> 대회 참여 못해 ㅠ 
// 6 3 2
//     1
//      