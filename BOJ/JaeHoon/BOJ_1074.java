package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
  static int N;
  static int r;
  static int c;
  static int cnt = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    N = (int)Math.pow(2, n);
    solve(N,0, 0);
  }
  public static void solve(int size,int row, int col) {

    //4등분을 해야함
    if(size == 2) {
      

      for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
          if(row + i == r && col+j == c) {
            //끝
            System.out.println(cnt);
            System.exit(0);
          }
          cnt++;
        }
      }
      return;      
    }else {
      size = size/2;

      for(int i=0; i<size*2; i+=size) {
        for(int j=0; j<size*2; j+=size) {
          if(row+i <= r && r < row+i+size && col+j <= c && c < col+j+size)
            solve(size,row+i,col+j);
          else 
            cnt += size*size;
        }
      }
    }
  }
}
