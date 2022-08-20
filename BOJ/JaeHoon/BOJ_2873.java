package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2873 {
  static int R;
  static int C;
  static int[][] map;
  static int[][] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String answer = "";
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    for(int i=0; i<R; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    if(R % 2 != 0 || C % 2 != 0)  {
      // 홀 홀 | 홀 짝 | 짝 홀 
      if(R % 2 != 0) {
        for(int i=1; i<=R; i++) {
          for(int j=1; j<C; j++) {
            if(i % 2 != 0) answer += "R";
            else answer += "L";
          }
          if(i != R)answer += "D";
        }
      }else {
        for(int i=1; i<=C; i++) {
          for(int j=1; j<R; j++) {
            if(i % 2 != 0) answer += "D";
            else answer += "U";
          }
          if(i != C)answer += "R";
        }
      }
      System.out.println(answer);
    }else {
      // 짝 짝
      int x = 0;
      int y = 1;
      for(int i=0; i<R; i++) {
        for(int j=0; j<C; j++) {
          if((i+j) % 2 != 0) {
            if(map[x][y] > map[i][j]) {
              x = i;
              y = j;
            }
          }
        }
      }
      int x1 = 0;
      int y1 = 0;
      int x2 = R-1;
      int y2 = C-1;
      StringBuilder s1 = new StringBuilder();
      StringBuilder s2 = new StringBuilder();
      while(x2 - x1 >  1) {
        if(x1/2 < x/2) {
          append(s1, 'R', C-1);
          append(s1, 'D', 1);
          append(s1, 'L', C-1);
          append(s1, 'D', 1);
          x1+=2;
        }
        if(x/2 < x2/2) {
          append(s2, 'R', C-1);
          append(s2, 'D', 1);
          append(s2, 'L', C-1);
          append(s2, 'D', 1);
          x2-=2;
        }
      }

      while(y2 - y1 > 1) {
        if(y1/2 < y/2) {
          append(s1, 'D', 1);
          append(s1, 'R', 1);
          append(s1, 'U', 1);
          append(s1, 'R', 1);
          y1+=2;
        }
        if(y/2 < y2/2) {
          append(s2, 'D', 1);
          append(s2, 'R', 1);
          append(s2, 'U', 1);
          append(s2, 'R', 1);
          y2-=2;
        }
      }
      if(y == y1) {
        append(s1, 'R', 1);
        append(s1, 'D', 1);
      }else {
        append(s1, 'D', 1);
        append(s1, 'R', 1);
      }
      s2.reverse();
      s1.append(s2);
      System.out.println(s1);
    }
  }
  public static void append(StringBuilder s,char c, int cnt) {
    for(int i=0; i<cnt; i++) 
      s.append(c);
  }
}

/*    
 *    O X O X 
 *    X O X O
 *    O X O X
 *    X O X O
 *    짝수일때에는 X인칸 중에서 하나를 빼고 다 가능 
 *    그니깐 X중에서 제일 작은 값을 선택해서 해당 경로를 지나지 않고 갈 수 있는 경로를 만들면 됨
 *    
 * 
 */
