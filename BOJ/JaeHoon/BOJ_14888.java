package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
  static int[] op;
  static int[] operator = new int[4];
  static int[] num;
  static int maxResult = Integer.MIN_VALUE;
  static int minResult = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    num = new int[N];
    op = new int[N-1];
    st = new StringTokenizer(br.readLine());
    for(int j=0; j<N; j++) {
      num[j] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int j=0; j<4; j++) {
      operator[j] = Integer.parseInt(st.nextToken());
    }
    bt(0,N);
    System.out.println(maxResult);
    System.out.println(minResult);
  }
  public static void bt(int depth,int N) {
    if(depth == N-1) {
      sum(N);
      return;
    }
    for(int i=0; i<4; i++) {
      if(operator[i] != 0) {
        op[depth] = i;
        operator[i] -= 1;
        bt( depth+1, N);
        operator[i] += 1;
      }
    }
  }
  public static void sum(int N) {
    int nowResult = num[0];
    for(int i=1; i<N; i++) {
      switch(op[i-1]) {
        case 0: 
          nowResult += num[i];
          break;
        case 1:   
          nowResult -= num[i];  
          break;
        case 2: 
          nowResult *= num[i];
          break;
        case 3: 
          nowResult /= num[i];
          break;
        default:
          break;
      }
    }
    maxResult = Math.max(maxResult, nowResult);
    minResult = Math.min(minResult, nowResult);
  }
}
