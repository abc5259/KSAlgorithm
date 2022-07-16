package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SCPC1 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      Point[] arr = new Point[N];
      Point[] sortArr = new Point[N];
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int p = Integer.parseInt(st.nextToken());
        arr[j] = new Point(p);
        sortArr[j] = new Point(p);
      }
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int v = Integer.parseInt(st.nextToken());
        arr[j].v = sortArr[j].v = v;
      }
      Arrays.sort(sortArr);
      int result = 0;
      for(int j=0; j<N; j++) {
        result += Math.abs(sortArr[j].p - arr[j].p);
      }
      sb.append("Case #").append(i+1).append('\n');
      sb.append(result).append('\n');
    }
    System.out.print(sb);
    br.close();
  }
  public static class Point implements Comparable<Point>{
    int p;
    int v;
    Point(int p) {
      this.p = p;
      this.v = 0;
    }
    
	  @Override
	  public int compareTo(Point o) {
      return this.v - o.v;
	  }
  }
}
