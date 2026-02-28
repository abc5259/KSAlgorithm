package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1038 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<List<List<Integer>>> memo = new ArrayList<>();
    for(int i=0; i<=9; i++) {
      memo.add(new ArrayList<>());
      for(int j=0; j<=11; j++) {
        memo.get(i).add(new ArrayList<>());
      }
    }

    memo.get(0).get(1).add(0);
    memo.get(1).get(1).add(1);
    memo.get(2).get(1).add(2);
    memo.get(3).get(1).add(3);
    memo.get(4).get(1).add(4);
    memo.get(5).get(1).add(5);
    memo.get(6).get(1).add(6);
    memo.get(7).get(1).add(7);
    memo.get(8).get(1).add(8);
    memo.get(9).get(1).add(9);
    memo.get(1).get(2).add(10);

    if(N <= 10) {
      System.out.println(N);
      return;
    }

    long cur = 20;
    int cnt = 2;
    int idx = 10;
    int mod = 10;
    while (idx < 1023) {
      // if(cur > 10000000000L) {
      //   System.out.println(-1);
      //   return;
      // }
      System.out.println("cur = " + cur + " cnt = " + cnt);
      int first = (int)(cur / mod);
      for(int i=0; i<first; i++) {
        for(int v: memo.get(i).get(cnt - 1)) {
          memo.get(first).get(cnt).add(first * mod + v);
          idx++;
          if(idx == N) {
            System.out.println(first * mod + v);
            return;
          }
        }
      }
      cur = ((long)first + 1) * mod;
      if(first == 9) {
        cnt++;
        mod *= 10;
      }
    }

    System.out.println(-1);
  }
}
