package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
  static int N,M;
  static int[][] map;
  static ArrayList<Home> homeList = new ArrayList<>();
  static ArrayList<int[]> ckHomeList = new ArrayList<>();
  static int[] arr;
  static boolean[] isOpen;
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) homeList.add(new Home(i, j));
        else if(map[i][j] == 2) ckHomeList.add(new int[]{i, j});
      }
    }
    isOpen = new boolean[ckHomeList.size()];
    
    solve(0, 0);
    System.out.println(answer);
  }
  public static void solve(int depth,int openCnt) {
    if(openCnt == M) {
      int total = 0;
      for(int i=0; i<homeList.size(); i++) {
        int x1 = homeList.get(i).x;
        int y1 = homeList.get(i).y;
        int min = Integer.MAX_VALUE;
        for(int j=0; j<ckHomeList.size(); j++) {
          if(!isOpen[j]) continue;
          int x2 = ckHomeList.get(j)[0];
          int y2 = ckHomeList.get(j)[1];
          min = Math.min(min, dist(x1, y1, x2, y2)); 
        }
        total += min;
      }
      answer = Math.min(answer, total);
      return;
    }

    for(int i=depth; i<ckHomeList.size(); i++) {
      if(!isOpen[i]) {
        isOpen[i] = true;
        solve(i+1, openCnt+1);
        isOpen[i] = false;    
      }
    }

  }
  public static int dist(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
  static class Home {
    public int x,y;
    Home(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
