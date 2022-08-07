package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
  static boolean[] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cnt = bfs(start, end);
      sb.append(cnt == -1 ? "Impossible" : cnt).append('\n');
    } 
    System.out.print(sb);
  }

  public static int bfs(int start,int end) {
    isVisit = new boolean[9000];
    Queue<Prime> q = new LinkedList<>();
    q.offer(new Prime(start, 0));
    isVisit[start-1000] = true;
    while(!q.isEmpty()) {
      Prime curr = q.poll();
      if(curr.num == end) return curr.cnt;
      int d4 = curr.num / 1000;
      int d3 = curr.num % 1000 / 100;
      int d2 = curr.num % 1000 % 100 / 10;
      int d1 = curr.num % 1000 % 100 % 10;
      // 1의 자릿수 바꾸기 
      for(int i=0; i<10; i++) {
        if(i == d1) continue;
        int num = d4 * 1000 + d3 * 100 + d2 * 10 + i;
        if(isVisit[num-1000] || !isPrime(num)) continue;
        isVisit[num-1000] = true;
        q.offer(new Prime(num, curr.cnt+1));
      }
      // 10의 자릿수 바꾸기
      for(int i=0; i<10; i++) {
        if(i == d2) continue;
        int num = d4 * 1000 + d3 * 100 + i * 10 + d1;
        if(isVisit[num-1000] || !isPrime(num)) continue;
        isVisit[num-1000] = true;
        q.offer(new Prime(num, curr.cnt+1));
      }
      // 100의 자릿수 바꾸기 
      for(int i=0; i<10; i++) {
        if(i == d3) continue;
        int num = d4 * 1000 + i * 100 + d2 * 10 + d1;
        if(isVisit[num-1000] || !isPrime(num)) continue;
        isVisit[num-1000] = true;
        q.offer(new Prime(num, curr.cnt+1));
      }
      // 1000의 자릿수 바꾸기 
      for(int i=1; i<10; i++) {
        if(i == d4) continue;
        int num = i * 1000 + d3 * 100 + d2 * 10 + d1;
        if(isVisit[num-1000] || !isPrime(num)) continue;
        isVisit[num-1000] = true;
        q.offer(new Prime(num, curr.cnt+1));
      }
    }
    return -1;
  }

  public static boolean isPrime(int n) {
    for(int i=2; i<=(int)Math.sqrt(n); i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static class Prime {
    int num;
    int cnt;
    Prime(int num, int cnt) {
      this.num = num;
      this.cnt = cnt;
    }
  }
}
