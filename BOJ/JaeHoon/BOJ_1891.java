package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1891 {
  static String findNum_s;
  static int d;
  static long x,y;
  static int[] quadrant = {2,1,3,4};
  static int cnt = 0;
  static long find_x = 0;
  static long find_y = 0;
  static long tx,ty;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    d = Integer.parseInt(st.nextToken());
    findNum_s = st.nextToken();
    st = new StringTokenizer(br.readLine());
    y = Long.parseLong(st.nextToken());
    x = Long.parseLong(st.nextToken());
    
    long n = 1L << d;
    findLoc(0, 0, 0, n, n);
    find_x -= x;
    find_y += y;
    if(0 <= find_x && find_x < n && 0 <= find_y && find_y < n) {
      check(d, find_x, find_y);
      System.out.println(sb);
    }else {
      System.out.println(-1);
    }
  }
  public static void check(int length, long tx, long ty) {
    if(length == 0) {
      return;
    }
    
    long half = 1L << (length - 1);
    // 0 1 2 3
    if(tx < half && ty >= half) {
      sb.append("1");
      check(length-1, tx, ty-half);
    }
    else if(tx < half && ty < half) {
      sb.append("2");
      check(length-1, tx, ty);
    }
    else if(tx >= half && ty < half) {
      sb.append("3");
      check(length-1, tx-half, ty);
    }
    else if(tx >= half && ty >= half) {
      sb.append("4");
      check(length-1, tx-half, ty-half);
    }
  }
  public static void findLoc(int index, long lx, long ly, long rx, long ry) {
    if(index == d) {
      find_x = lx;
      find_y = ly;
      return;
    }

    int num = findNum_s.charAt(index) - '0';

    if(num == 1) {
      findLoc(index+1,lx,(ly+ ry)/2,(lx + rx) /2, ry);
    }
    else if(num == 2) {
      findLoc(index+1,lx,ly,(lx + rx)/2 , (ly + ry) / 2);
    }
    else if(num == 3) {
      findLoc(index+1,(lx+rx)/2,ly,rx , (ly + ry) / 2);
    }
    else if(num == 4) {
      findLoc(index+1,(lx+rx)/2,(ly + ry) / 2, rx , ry);
    }
    
  }
}
