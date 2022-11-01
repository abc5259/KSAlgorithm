package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2258 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken()); 
    Meat[] meats = new Meat[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      meats[i] = new Meat(w, cost);
    }
    Arrays.sort(meats,(Meat o1, Meat o2) -> {
      if(o1.cost == o2.cost) return o2.w - o1.w;
      return o1.cost - o2.cost;
    });
    
    int totalCost = 0;
    int totalWeight = 0;
    int answer = Integer.MAX_VALUE;
    boolean check = false;

    for(int i=0; i<N; i++) {

      totalWeight += meats[i].w;

      if(i > 0 && meats[i].cost == meats[i-1].cost) {
        totalCost += meats[i].cost;
      }else {
        totalCost = meats[i].cost;
      }

      if(totalWeight >= M) {
        check = true;
        answer = Math.min(answer, totalCost);
      }
    }
    System.out.println(check ? answer : -1);
  }
  static class Meat {
    int w,cost;
    int total = 0;
    Meat(int w, int cost) {
      this.w = w;
      this.cost = cost;
      total = w;
    }
  }
}
