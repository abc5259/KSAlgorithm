package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20166 {
  static char[][] map;
  static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
  static int N,M;
  static int cnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new char[N+1][M+1];
    for(int i=1; i<=N; i++) {
      String s = br.readLine();
      for(int j=1; j<=M; j++) {
        map[i][j] = s.charAt(j-1);
      }
    }
    StringBuffer sb = new StringBuffer();
    String[] s = new String[K];
    for(int t=0; t<K; t++) {
      s[t] = br.readLine();
    }
    Map<String,Integer> hahMap = new HashMap<>();
    for(int t=0; t<K; t++) {
      if(hahMap.containsKey(s[t])) {
        sb.append(hahMap.get(s[t])).append('\n');
      }else {
        for(int i=1; i<=N; i++) {
          for(int j=1; j<=M; j++) { 
            if(s[t].charAt(0) == map[i][j])
              dfs(1, s[t], i, j);
          }
        }
        hahMap.put(s[t], cnt);
        sb.append(cnt).append('\n');
        cnt = 0;
      }
    }
    System.out.println(sb);
    
  }
  public static void dfs(int depth, String s, int row, int col) {
    if(depth == s.length()) {
      cnt++;
      return;
    }

    for(int i=0; i<8; i++) {
      int nextRow = row + dir[i][0];
      int nextCol = col + dir[i][1];
      if(nextRow == 0) nextRow = N;
      if(nextRow == N+1) nextRow = 1;
      if(nextCol == 0) nextCol = M;
      if(nextCol == M+1) nextCol = 1;
      if(s.charAt(depth) == map[nextRow][nextCol])
        dfs(depth+1, s, nextRow, nextCol);
    }

    return;

  }
}
