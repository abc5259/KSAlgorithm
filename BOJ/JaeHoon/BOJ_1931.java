package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    Meeting[] meetings = new Meeting[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(meetings);
    
    int answer = 1;
    int startTime = meetings[0].end;
    for(int i=1; i<N; i++) {
      if(startTime <= meetings[i].start) {
        answer++;
        startTime = meetings[i].end;
      }
    }
    System.out.println(answer);
  }
  static class Meeting implements Comparable<Meeting>{
    int start,end;
    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }
    public int getTotalTime() {
      return this.end - this.start;
    }
    @Override
    public int compareTo(Meeting o) {
      if(this.end == o.end) return this.start - o.start;
      return this.end - o.end;
    }
  }
}
