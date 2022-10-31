package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_5397 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    String[] arr = new String[L];
    StringBuffer sb = new StringBuffer();    
    for(int i=0; i<L; i++) {
      arr[i] = br.readLine();
      sb.append(solove(arr[i])).append('\n');
    }
    System.out.println(sb);
  }
  static public String solove(String str) {
    Stack<Character> stack = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    for(int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      switch(c) {
        case '<':
          if(!stack.isEmpty()) 
            stack2.push(stack.pop());
          break;
        case '>':
          if(!stack2.isEmpty())
            stack.push(stack2.pop());
          break;
        case '-':
          if(!stack.isEmpty())
            stack.pop();
          break;
        default: 
          stack.push(c);
          break;
      }
    }
    while(!stack2.isEmpty()) {
      stack.push(stack2.pop());
    }
    StringBuffer st = new StringBuffer();
    while(!stack.isEmpty()) {
      st.append(stack.pop());
    }
    return st.reverse().toString();
  }
}
