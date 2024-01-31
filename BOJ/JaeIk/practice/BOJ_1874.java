package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    static String NO = "NO";
    static String PUSH = "+";
    static String POP = "-";
    static int n;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        int start = 0;

        while(n-- > 0){
            int input = Integer.parseInt(br.readLine());

            if(start < input){
                for(int i=start+1; i<=input; i++){
                    stack.push(i);
                    sb.append(PUSH).append("\n");
                }
                start = input;
            }

            else if(stack.peek() != input){
                System.out.println(NO);
                return;
            }

            stack.pop();
            sb.append(POP).append("\n");
        }

        System.out.println(sb);
    }
}
