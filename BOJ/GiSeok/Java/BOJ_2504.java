package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split("");
        Stack<String> stk = new Stack<>();
        int ans = 0;
        int value = 1;

        for (int i = 0; i < exp.length; i++) {
            if (exp[i].equals("(")) {
                stk.push(exp[i]);
                value *= 2;
            } else if (exp[i].equals("[")) {
                stk.push(exp[i]);
                value *= 3;
            }

            if (exp[i].equals(")")) {
                if (stk.isEmpty() || !stk.peek().equals("(")) {
                    ans = 0;
                    break;
                }

                if (exp[i-1].equals("("))
                    ans += value;

                stk.pop();
                value /= 2;
            } else if (exp[i].equals("]")) {
                if (stk.isEmpty() || !stk.peek().equals("[")) {
                    ans = 0;
                    break;
                }
                
                if (exp[i-1].equals("["))
                    ans += value;
                
                stk.pop();
                value /= 3;
            }
        }
        
        if (!stk.isEmpty()) ans = 0;
        System.out.println(ans);
    }
}
