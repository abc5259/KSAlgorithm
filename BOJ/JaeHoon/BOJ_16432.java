package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16432 {
  static int N;
  static ArrayList<int[]> arr;
  static StringBuffer sb = new StringBuffer();
  static boolean ok = false;
  static int[] answer;
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    arr = new ArrayList<>();
    answer = new int[N];
    isVisit = new boolean[N+1][10];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      int[] addArr = new int[length];
      for(int j=0; j<length; j++) {
        addArr[j] = Integer.parseInt(st.nextToken());
      }
      arr.add(addArr);
    }
    boolean isOk = true;
    for(int i=0; i<N-1; i++) {
      if(arr.get(i).length == 1) {
        if(arr.get(i+1).length == 1 && arr.get(i)[0] == arr.get(i+1)[0]) {
          isOk = false;
          break;
        }

        if(i != N-2) {
          if(arr.get(i+1).length == 2 && arr.get(i+2).length == 1 &&  arr.get(i)[0] != arr.get(i+2)[0]) {
            int min = Math.min(arr.get(i)[0], arr.get(i+2)[0]);
            int max = Math.max(arr.get(i)[0], arr.get(i+2)[0]);
            if(arr.get(i+1)[0] == min && arr.get(i+1)[1] == max) {
              isOk = false;
              break;
            }
          }
        }
      }
    }

    if(isOk) {
      dfs(0,-1);
      System.out.println(-1);
    }else {
      System.out.println(-1);
    }
  }
  public static void dfs(int depth,int prev) {

    if(depth == N) {
      for(int i=0; i<N; i++) {
        sb.append(answer[i]+"\n");
      }
      System.out.println(sb);
      System.exit(0);
      return;
    }
    
    for(int next:arr.get(depth)) {
      if(next == prev || isVisit[depth+1][next]) continue;
      isVisit[depth+1][next] = true;
      answer[depth] = next;
      dfs(depth+1, next);
    }
  }
}
