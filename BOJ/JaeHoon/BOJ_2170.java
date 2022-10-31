package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    Point[] arr = new Point[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[i] = new Point(x, y);
    }
    Arrays.sort(arr,(Point o1, Point o2) -> {
      if(o1.x == o2.x) 
        return o1.y - o2.y;
      return o1.x - o2.x;  
    });
    int prevX = arr[0].x;
    int prevY = arr[0].y;
    int sum = arr[0].y - arr[0].x;
    for(int i=1; i<N; i++) {
      if(arr[i].x < prevY) {
        if(arr[i].y > prevY) {
          sum += arr[i].y - prevY;
          prevX = arr[i].x;
          prevY = arr[i].y;
        }
      }else {
        sum += arr[i].y - arr[i].x;
        prevX = arr[i].x;
        prevY = arr[i].y;
      }
    }
    System.out.println(sum);
  }
  static class Point {
    int x,y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
