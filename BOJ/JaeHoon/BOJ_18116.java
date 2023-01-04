package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_18116 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] parents = new int[1000001];
    int[] cnt = new int[1000001];
    for(int i=1; i<=1000000; i++) {
      parents[i] = i;
      cnt[i] = 1;
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String c = st.nextToken();
      if(c.equals("I")) {
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(parents[a] != parents[b])
          union(parents, a, b,cnt);
      } 
      else if(c.equals("Q")) {
        int robot = Integer.parseInt(st.nextToken());
        sb.append(cnt[find(parents, robot)]+"\n");
      }
    }
    System.out.print(sb);
  }
  public static int find(int[] parents, int a) {
    if(parents[a] == a) return a;
    return parents[a] = find(parents, parents[a]);
  }
  public static void union(int[] parents, int a, int b, int[] cnt) {
    a = find(parents, a);
    b = find(parents, b);
    if(a != b) {
      parents[a] = b;
      cnt[b] += cnt[a];
      cnt[a] = 0;
    }
  }
}

// I 1 2
// I 4 1