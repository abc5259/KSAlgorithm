package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12886 {
    static int[] groups = new int[3];
    static boolean[][] isVisit = new boolean[1501][1501];
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<3; i++) {
        groups[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(bfs(new Group(groups[0], groups[1], groups[2])));
    }
    public static int bfs(Group start) {
      Queue<Group> q = new LinkedList<>();
      q.offer(start);
      isVisit[start.A][start.B] = true;
      while(!q.isEmpty()) {
        Group now = q.poll();
        if(now.A == now.B && now.B == now.C) return 1;
        if(now.A < now.B) {
          int nextA = now.A * 2;
          int nextB = now.B - now.A;
          if(!isVisit[nextA][nextB]) {
            q.offer(new Group(nextA, nextB, now.C));
            isVisit[nextA][nextB] = true;
          }
        }
        if(now.A > now.B) {
          int nextB = now.B * 2;
          int nextA = now.A - now.B;
          if(!isVisit[nextA][nextB]) {
            q.offer(new Group(nextA, nextB, now.C));
            isVisit[nextA][nextB] = true;
          }
        }
        if(now.A < now.C) {
          int nextA = now.A * 2;
          int nextC = now.C - now.A;
          if(!isVisit[nextA][nextC]) {
            q.offer(new Group(nextA, now.B, nextC));
            isVisit[nextA][nextC] = true;
          }
        }
        if(now.A > now.C) {
          int nextC = now.C * 2;
          int nextA = now.A- now.C;
          if(!isVisit[nextA][nextC]) {
            q.offer(new Group(nextA, now.B, nextC));
            isVisit[nextA][nextC] = true;
          }
        }
        if(now.B < now.C) {
          int nextB = now.B * 2;
          int nextC = now.C - now.B;
          if(!isVisit[nextB][nextC]) {
            q.offer(new Group(now.A, nextB, nextC));
            isVisit[nextB][nextC] = true;
          }
        }
        if(now.B > now.C) {
          int nextC = now.C * 2;
          int nextB = now.B - now.C;
          if(!isVisit[nextB][nextC]) {
            q.offer(new Group(now.A, nextB, nextC));
            isVisit[nextB][nextC] = true;
          }
        }
      }
      return 0;
    }
    static class Group {
      int A;
      int B;
      int C;
      Group(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
      }
    }
}
