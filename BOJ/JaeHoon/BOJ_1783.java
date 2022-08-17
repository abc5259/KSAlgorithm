package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int answer = 1;
    int move = M - 1;
    if(N > 2) {
      if(move > 4) {
        move -= 2;
      }
      else if(move == 4) {
        move -= 1;
      }
      answer += move;
    }else if(N == 2){
      move /= 2;
      if(move >= 4) {
        answer = 4;
      }else {
        answer += move;
      }
    }
    System.out.println(answer);
  }
}

/*
 *  병든 나이트 
 *  - 체스 판에서 가장 왼쪽 아래에 위치 
 *  - 건강한 체스의 나이트와 다르게 움직임
 *   - {{2,1},{1,2},{-1,2},{-2,1}}
 *  - 병든 나이트가 방문한 칸의 수의 최댓값을 구해야함
 *  - 이동횟수 >= 4 라면 이동 방법을 모두 한 번 씩 사용해야함
 *  - 이동횟수 < 4 라면 이동 방법에 제약 x
 */