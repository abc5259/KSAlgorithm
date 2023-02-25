package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());

    int wMax = Integer.MIN_VALUE;
    int wDir = -1;
    int wIdx = -1;

    int hMax = Integer.MIN_VALUE;
    int hDir = -1;

    Point[] points = new Point[6];
    for(int i=0; i<6; i++) {
      st = new StringTokenizer(br.readLine());
      points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      if(points[i].dir == 1 || points[i].dir == 2) { //동쪽 이거나 서쪽 
        if(points[i].round > wMax) {
          wMax = points[i].round;
          wDir = points[i].dir;
          wIdx = i;
        }
      }
      if(points[i].dir == 3 || points[i].dir == 4) { //남쪽 이거나 북쪽 
        if(points[i].round > hMax) {
          hMax = points[i].round;
          hDir = points[i].dir;
        }
      }
    }
    int result = wMax * hMax;
    int idx1 = -1;
    int idx2 = -1;

    if(wDir == 2 && hDir == 4) {
      idx1 = (wIdx + 2) % 6;
      idx2 = (idx1 + 1) % 6;
    }
    else if(wDir == 2 && hDir == 3) {
      idx1 = (wIdx + 3) % 6;
      idx2 = (idx1 + 1) % 6;
    }
    else if(wDir == 1 && hDir == 3) {
      idx1 = (wIdx + 2) % 6;
      idx2 = (idx1 + 1) % 6;
    }
    else if(wDir == 1 && hDir == 4) {
      idx1 = (wIdx + 3) % 6;
      idx2 = (idx1 + 1) % 6;
    }
    
    result -= points[idx1].round * points[idx2].round;
    System.out.println(result*K);
  }
  static class Point {
    int dir,round;
    Point(int dir,int round) {
      this.dir = dir;
      this.round = round;
    }
  }
}
