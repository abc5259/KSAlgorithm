package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205 {
  static int[] home;
  static int[][] stores;
  static int[] end;
  static int N;
  static boolean[] isVisit;
  static boolean answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(br.readLine());

    while(T > 0) {
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      home = new int[2];
      home[0] = Integer.parseInt(st.nextToken());
      home[1] = Integer.parseInt(st.nextToken());
      
      stores = new int[N][2];
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        stores[i][0] = Integer.parseInt(st.nextToken());
        stores[i][1] = Integer.parseInt(st.nextToken());
      }
      
      st = new StringTokenizer(br.readLine());
      end = new int[2];
      end[0] = Integer.parseInt(st.nextToken());
      end[1] = Integer.parseInt(st.nextToken());
      
      isVisit = new boolean[N];
      solve(home[0],home[1],distance(home[0], home[1], end[0], end[1]));
      if(answer)
        sb.append("happy\n");
      else 
        sb.append("sad\n");

      answer = false;
      T--;
    }
    System.out.println(sb);
  }
  public static void solve(int x, int y, int rockDist) {
    if(answer) return;
    if(canGo(rockDist)) {
      answer = true;
      return;
    }

    for(int i=0; i<N; i++) {
      if(answer) return;
      if(isVisit[i]) continue;
      int dist = distance(x, y, stores[i][0], stores[i][1]);
      int nextRockDist = distance(end[0], end[1], stores[i][0], stores[i][1]);
      if(canGo(dist)) {
        isVisit[i] = true;
        solve(stores[i][0], stores[i][1], nextRockDist);
      }
    }
  }
  public static boolean canGo(int dist) {
    return dist <= 1000;
  }
  public static int distance(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
