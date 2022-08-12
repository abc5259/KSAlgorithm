package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    Lecture[] lectures = new Lecture[n];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(lectures);
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    int answer = 0;
    int j=0;
    if(lectures.length >= 1) {
      for(int i = lectures[0].d; i >=1; i--) {
        // 해당날에 강연을 할 수 있는지
        // 해당날 보다 d값이 크거나 같을때 강연 가능
        while(j < n && i <= lectures[j].d) {
          q.offer(lectures[j].p);
          j++;
        }
  
        if(!q.isEmpty()) {
          answer += q.poll();
        }
      }
    }
    System.out.println(answer);
  }
  public static class Lecture implements Comparable<Lecture>{
    int p,d;
    Lecture(int p, int d) {
      this.p = p;
      this.d = d;
    }
    @Override
    public int compareTo(Lecture o) {
      return o.d - this.d;
    }
  }
}


// 10 1
// 30 1
// 20 2
// 50 2

// 2 50
// 2 40
// 1 30

// 제일 날짜가 큰날부터 지정
// 큐:  2 50 2 40 2 30
// 2일에는 50
// 1일에는 

