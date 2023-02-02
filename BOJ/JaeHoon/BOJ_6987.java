package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987 {
  static int[] arr = new int[18];
  static boolean[] isVisit = new boolean[6];
  static int input[][],t1[],t2[];
  static boolean isOk;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    input = new int[4][18];
    for(int i=0; i<4; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<18; j++) {
        input[i][j] = Integer.parseInt(st.nextToken());
      }
    }

		t1 = new int[15];		//경기하는 2팀
		t2 = new int[15];
    int idx=0;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<=5;j++) {
				t1[idx]=i;
				t2[idx]=j;
        idx++;
			}
		}
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<4; i++) {
      int sum = 0;
      for(int j=0; j<18; j++) {
        sum += input[i][j];
      }
      if(sum != 30) sb.append(0 + " ");
      else {
        solve(0, i);
        if(isOk) {
          sb.append(1+ " ");
        }else {
          sb.append(0+ " ");
        }
        isOk = false;
      }
    }
    System.out.println(sb);
  }
  public static void solve(int depth, int inputIdx) {
    if(isOk) return;
    if(depth == 15) { 
      isOk = true;
      return;
    }

    int teamA = t1[depth];
    int teamB = t2[depth];

    //이겼을때
    if(input[inputIdx][teamA*3] > 0 && input[inputIdx][teamB*3+2] > 0) {  
      input[inputIdx][teamA*3]-=1;
      input[inputIdx][teamB*3+2]-=1;
      solve(depth+1, inputIdx);
      input[inputIdx][teamA*3]+=1;
      input[inputIdx][teamB*3+2]+=1;
    }

    //비겼을떄
    if(input[inputIdx][teamA*3+1] > 0 && input[inputIdx][teamB*3+1] > 0) {
      input[inputIdx][teamA*3+1]-=1;
      input[inputIdx][teamB*3+1]-=1;
      solve(depth+1,inputIdx);
      input[inputIdx][teamA*3+1]+=1;
      input[inputIdx][teamB*3+1]+=1;
    }

    //졌을때
    if(input[inputIdx][teamA*3+2] > 0 && input[inputIdx][teamB*3] > 0) {
      input[inputIdx][teamA*3+2]-=1;
      input[inputIdx][teamB*3]-=1;
      solve(depth+1,inputIdx);
      input[inputIdx][teamA*3+2]+=1;
      input[inputIdx][teamB*3]+=1;
    }
   
  }
}
