package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12919 {
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();
    System.out.println(bfs(T, S) ? 1 : 0);
  }
  public static boolean bfs(String start,String end) {
    Queue<String> q = new LinkedList<>();
    q.offer(start);
    while(!q.isEmpty()) {
      String curr = q.poll();
      if(curr.length() < end.length()) return false;
      if(curr.charAt(0) == 'A' && curr.charAt(curr.length() - 1) == 'A') {
        String next = curr.substring(0, curr.length() - 1);
        if(next.equals(end)) return true;
        q.offer(next);
      }
      else if(curr.charAt(0) == 'B' && curr.charAt(curr.length() - 1) == 'A') {
        String next1 = curr.substring(0, curr.length() - 1);
        sb = new StringBuffer(curr);
        String next2 = sb.reverse().toString().substring(0, curr.length() - 1);
        if(next1.equals(end) || next2.equals(end)) return true;
        q.offer(next1);
        q.offer(next2);
      }
      else if(curr.charAt(0) == 'B') {
        sb = new StringBuffer(curr);
        String next = sb.reverse().toString().substring(0, curr.length() - 1);
        if(next.equals(end)) return true;
        q.offer(next);
      }
    }
    return false;
  }
}