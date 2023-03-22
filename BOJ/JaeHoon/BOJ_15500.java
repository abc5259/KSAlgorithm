package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15500 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> stack3 = new Stack<>();
    st = new StringTokenizer(br.readLine());
    int[] pos = new int[N+1];
    for(int i=0; i<N; i++) {
      stack1.push(Integer.parseInt(st.nextToken()));
      pos[i+1] = 1;
    }

    int target = N;
    StringBuffer sb = new StringBuffer();
    int cnt = 0;
    while(target > 0) {
      if(pos[target] == 1) {
        while(stack1.peek() != target) {
          cnt++;
          int n = stack1.pop();
          stack2.push(n);
          pos[n] = 2;
          sb.append("1 2").append("\n");
        }
        cnt++;
        int n = stack1.pop();
        stack3.push(n);
        pos[n] = 3;
        sb.append("1 3").append("\n");
        target -= 1;
      }
      else if(pos[target] == 2) {
        while(stack2.peek() != target) {
          cnt++;
          int n = stack2.pop();
          stack1.push(n);
          pos[n] = 1;
          sb.append("2 1").append("\n");
        }
        cnt++;
        int n = stack2.pop();
        stack3.push(n);
        pos[n] = 3;
        sb.append("2 3").append("\n");
        target -= 1;
      }
    }
    System.out.println(cnt);
    System.out.println(sb);
  } 
}
