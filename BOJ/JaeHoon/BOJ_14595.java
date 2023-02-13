package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14595 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(br.readLine());
    int[][] action = new int[M][2];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      action[i][0] = Integer.parseInt(st.nextToken());
      action[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(action,(a,b) -> {
      if(a[0] == b[0]) return a[1] - b[1];
      return a[0] - b[0];
    });

    ArrayList<int[]> acList = new ArrayList<>();
    if(M > 0) {
      int start = action[0][0];
      int end = action[0][1];
      for(int i=1; i<M; i++) {
        if(end >= action[i][0]) {
          if(end < action[i][1])
            end = action[i][1];
        }else {
          acList.add(new int[]{start,end});
          start = action[i][0];
          end = action[i][1];
        }
      }
      acList.add(new int[]{start,end});
      
      int answer = N;
      for(int[] a:acList) {
        answer -= (a[1] - a[0]);
      }
      System.out.println(answer);
    }else {
      System.out.println(N);
    }
  }
}
