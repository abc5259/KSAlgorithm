package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15565 {
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Map<Integer,Integer> map = new HashMap<>();
    int total = 0;
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
      if(num == 1) {
        total++;
        map.put(total, i);
      }
    }
    if(K > total) {
      System.out.println(-1);
    }else {
      answer = Integer.MAX_VALUE;
      map.forEach((Integer sum, Integer index) -> {
        int findSum = sum + K - 1;
        if(map.containsKey(findSum)) {
          int findIdx = map.get(findSum);
          answer = Math.min(findIdx - index + 1, answer);
        }
      });
      System.out.println(answer);
    }

  }
}
