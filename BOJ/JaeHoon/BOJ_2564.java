package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class BOJ_2564 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int C = Integer.parseInt(br.readLine());
    int[][] arr = new int[C][2];
    for(int i=0; i<C; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] start = new int[2];
    st = new StringTokenizer(br.readLine());
    start[0] = Integer.parseInt(st.nextToken());
    start[1] = Integer.parseInt(st.nextToken());

    int result = 0;
    for(int i=0; i<C; i++) {
      int rightDist = 0;
      int curD = start[0];
      int curP = start[1];
      while (curD != arr[i][0]) {
        if(curD == 1) {
          rightDist += curP;
          curD = 3;
          curP = 0;
        }
        else if(curD == 2) {
          rightDist += M - curP;
          curD = 4;
          curP = N;
        }
        else if(curD == 3) {
          rightDist += N - curP;
          curD = 2;
          curP = 0;
        }
        else if(curD == 4) {
          rightDist += curP;
          curD = 1;
          curP = M;
        }
      }
      rightDist += Math.abs(curP - arr[i][1]);


      int leftDist = 0;
      curD = start[0];
      curP = start[1];
      while (curD != arr[i][0]) {
        if(curD == 1) {
          leftDist += M - curP;
          curD = 4;
          curP = 0;
        }
        else if(curD == 2) {
          leftDist += curP;
          curD = 3;
          curP = N;
        }
        else if(curD == 3) {
          leftDist += curP;
          curD = 1;
          curP = 0;
        }
        else if(curD == 4) {
          leftDist += N - curP;
          curD = 2;
          curP = M;
        }
      }
      leftDist += Math.abs(curP - arr[i][1]);

      result += Math.min(rightDist, leftDist);
    }
    System.out.println(result);
  }
}
