package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14395 {
  static HashSet<Integer> visited = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    System.out.println(s == t ? '0' : bfs(s, t));
  }
  public static String bfs(int s, int t) {
    Queue<Num> q = new LinkedList<>();
    q.offer(new Num(s, ""));
    visited.add(s);

    while(!q.isEmpty()) {
      Num curr = q.poll();
      if(curr.s == t) return curr.result;

      for(int i=0; i<3; i++) {
        long temp = curr.s;
        if(i == 0) temp *= temp;
        else if(i == 1) temp += temp;
        else temp /= temp;

        if(temp > t) continue;
        if(visited.contains((int)temp)) continue;

        if(i == 0) q.offer(new Num((int)temp, curr.result+"*"));
        else if(i == 1) q.offer(new Num((int)temp, curr.result+"+")); 
        else q.offer(new Num((int)temp, curr.result+"/"));

        visited.add((int)temp);

      }
    }
    
    return "-1";
  }
  public static class Num{
    int s;
    String result;
    Num(int s,String result) {
      this.s = s;
      this.result = result;
    }
  }
}
