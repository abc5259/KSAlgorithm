package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
  static int[] map;
  static boolean[] isVisit;
  static ArrayList<Integer> arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    map = new int[N*N];
    isVisit = new boolean[N*N];
    arr = new ArrayList<>();
    for(int i=0; i<N; i++) {
      String str = br.readLine();
      for(int j=0; j<N; j++) {
        map[i*N + j] = str.charAt(j) - '0';
      }
    }
    for(int i=0; i<N*N; i++) {
      if(!isVisit[i] && map[i] == 1)
        bfs(i, N);
    }
    Collections.sort(arr);
    sb.append(arr.size()).append('\n');
    for(int i=0; i<arr.size(); i++) {
      sb.append(arr.get(i)).append('\n');
    }
    System.out.println(sb);
  }
  public static int bfs(int start,int N) {
    Queue<Integer> queue = new LinkedList<>();
    int num = 1;
    queue.offer(start);
    isVisit[start] = true;
    while(!queue.isEmpty()) {
      int v = queue.poll();
      int i = v/N;
      int j = v%N;
      if(j < N-1 && map[v+1] == 1 && !isVisit[v+1]) {
        isVisit[v+1] = true;
        queue.offer(v+1);
        num++;
      }
      if(j > 0 && map[v-1] == 1 && !isVisit[v-1]) {
        isVisit[v-1] = true;
        queue.offer(v-1);
        num++;
      }
      if(i < N-1 && map[v+N] == 1 && !isVisit[v+N]) {
        isVisit[v+N] = true;
        queue.offer(v+N);
        num++;
      }
      if(i > 0 && map[v-N] == 1 && !isVisit[v-N]) {
        isVisit[v-N] = true;
        queue.offer(v-N);
        num++;
      }
    }
    if(num > 0) {
      arr.add(num);
    }
    return num;
  }
}
