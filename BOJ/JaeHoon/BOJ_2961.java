package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
  static Item[] items;
  static boolean[] isUsed;
  static int N;
  static long answer = Long.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    // 신맛 곱  | 쓴맛 합  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    items = new Item[N];
    isUsed = new boolean[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    solve(0, 1, 0);
    System.out.println(answer);
  }
  public static void solve(int depth, long sour, long bitterness) {
    if(depth != 0) {
      answer = Math.min(answer, Math.abs(sour - bitterness));
    }
    if(depth == N) return;
    for(int i=0; i<N; i++) {
      if(!isUsed[i]) {
        isUsed[i] = true;
        solve(depth+1, sour*items[i].sour, bitterness + items[i].bitterness);
        isUsed[i] = false;
      }
    }
  }
  static class Item {
    // 신맛, 쓴맛 
    int sour,bitterness;
    Item(int sour, int bitterness) {
      this.sour = sour;
      this.bitterness = bitterness;
    }
  }
}
