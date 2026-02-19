package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14890 {
  static int N, L;
  static int[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      } 
    }
    int result = 0;
    for(int i=0; i<N; i++) {
      if(check(i)) result++;
    }

    for(int j=0; j<N; j++) {
      if(check2(j)) result++;
    }

    System.out.println(result);
  }

  public static boolean check(int i) {
    Set<Integer> used = new HashSet<>();
    for(int j=0; j<N-1; j++) {
      if(map[i][j] != map[i][j+1]) {
        if(Math.abs(map[i][j] - map[i][j+1]) != 1)  { //걍사로 차이가 1이 아닌 경우 
          return false;
        }
        if(map[i][j] < map[i][j+1]) {
          if(j - L + 1 < 0) { //L 위치에 칸 개수가 부족하면 false. 
            return false;
          }
          int v = map[i][j];
          for(int k=j - L + 1; k<=j; k++) {
            if(map[i][k] != v || used.contains(k)) { //L개가 같은 높이가 아니거나 이미 사용된 칸이라면 false
              return false;
            }
          }
          // 가능하므로 다 used에 넣기 
          for(int k=j - L + 1; k<=j; k++) {
            used.add(k);
          }
        }else {
          if(j + L >= N) {
            return false;
          }
          int v = map[i][j+1];
          for(int k=j+1; k<=j+L; k++) {
            if(map[i][k] != v || used.contains(k)) { //L개가 같은 높이가 아니거나 이미 사용된 칸이라면 false
              return false;
            }
          }
          // 가능하므로 다 used에 넣기 
          for(int k=j + 1; k<=j+L; k++) {
            used.add(k);
          }
        }
      }
    }
    return true;
  }
  public static boolean check2(int j) {
    Set<Integer> used = new HashSet<>();
    for(int i=0; i<N-1; i++) {
      if(map[i][j] != map[i+1][j]) {
        if(Math.abs(map[i][j] - map[i+1][j]) != 1)  { //걍사로 차이가 1이 아닌 경우 
          return false;
        }
        if(map[i][j] < map[i+1][j]) {
          if(i - L + 1 < 0) { //L 위치에 칸 개수가 부족하면 false. 
            return false;
          }
          int v = map[i][j];
          for(int k=i - L + 1; k<=i; k++) {
            if(map[k][j] != v || used.contains(k)) { //L개가 같은 높이가 아니거나 이미 사용된 칸이라면 false
              return false;
            }
          }
          // 가능하므로 다 used에 넣기 
          for(int k=i - L + 1; k<=i; k++) {
            used.add(k);
          }
        }else {
          if(i + L >= N) {
            return false;
          }
          int v = map[i+1][j];
          for(int k=i+1; k<=i+L; k++) {
            if(map[k][j] != v || used.contains(k)) { //L개가 같은 높이가 아니거나 이미 사용된 칸이라면 false
              return false;
            }
          }
          // 가능하므로 다 used에 넣기 
          for(int k=i + 1; k<=i+L; k++) {
            used.add(k);
          }
        }
      }
    }
    return true;
  }
}
