package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_3425 {
  static StringBuffer sb = new StringBuffer();
  static int MAX = 1000000000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> arr = new ArrayList<>();
    while(true) {
      String cmd = br.readLine();
      if(cmd.equals("QUIT")) break;
      if(!cmd.equals("END")) {
        arr.add(cmd);
      }
      else {
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
          int num = Integer.parseInt(br.readLine());
          solve(arr, num);
        }
        arr = new ArrayList<>();
        sb.append('\n');
        br.readLine();
      }
    }
    System.out.print(sb);
  }
  public static void solve(ArrayList<String> arr, int num) {
    Stack<Long> stack = new Stack<>();
    stack.push((long)num);
    
    for(String s:arr) {
      String[] cmd = s.split(" ");
      switch (cmd[0]) {
        case "NUM":
          stack.push(Long.parseLong(cmd[1]));
          break;
        case "POP":
          if(stack.size() < 1) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.pop();
          break;
        case "INV":
          if(stack.size() < 1) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.push(-1 * stack.pop());
          break;
        case "DUP":
          if(stack.size() < 1) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.push(stack.peek());
          break;
        case "SWP":
          {
            if(stack.size() < 2) {
              sb.append("ERROR").append('\n');
              return;
            }
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            stack.push(second);
            break;
          }
        case "ADD": {
          if(stack.size() < 2) {
            sb.append("ERROR").append('\n');
            return;
          }
          long first = stack.pop();
          long second = stack.pop();
          if((long)Math.abs(first + second) > MAX) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.push(first + second);
          break;
        }
        case "SUB": {
          if(stack.size() < 2) {
            sb.append("ERROR").append('\n');
            return;
          }
          long first = stack.pop();
          long second = stack.pop();
          if((long)Math.abs(second - first) > MAX) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.push(second - first);
          break;
        }
        case "MUL": {
          if(stack.size() < 2) {
            sb.append("ERROR").append('\n');
            return;
          }
          long first = stack.pop();
          long second = stack.pop();
          if((long)Math.abs(first * second) > MAX) {
            sb.append("ERROR").append('\n');
            return;
          }
          stack.push((long)(first * second));
          break;
        }
        case "DIV": {
          if(stack.size() < 2) {
            sb.append("ERROR").append('\n');
            return;
          }
          long first = stack.pop();
          long second = stack.pop();
          int minusSize = 0;
          if(first < 0) minusSize++;
          if(second < 0) minusSize++;
          if(first == 0) {
            sb.append("ERROR").append('\n');
            return;
          }
          long n = minusSize == 1 ? -1 * (Math.abs(second) / Math.abs(first)) : Math.abs(second) / Math.abs(first);
          stack.push(n);
          break;
        }
        case "MOD": {
          if(stack.size() < 2) {
            sb.append("ERROR").append('\n');
            return;
          }
          long first = stack.pop();
          long second = stack.pop();
          if(first == 0) {
            sb.append("ERROR").append('\n');
            return;
          }
          long n = second < 0 ? -1 * Math.abs(second) % Math.abs(first) : Math.abs(second) % Math.abs(first);
          stack.push(n);
          break;
        }
        default:
          break;
      }
    }
    
    // System.out.println(stack);
    if(stack.size() != 1) sb.append("ERROR").append('\n');
    else sb.append(stack.pop()).append('\n');
  }
}
