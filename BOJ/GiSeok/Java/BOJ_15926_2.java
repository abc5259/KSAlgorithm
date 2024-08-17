package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_15926_2 {
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') stk.push(i);
            else {
                stk.pop();
                if (!stk.isEmpty()) {
                    ret = Math.max(ret, i - stk.peekLast());
                } else stk.push(i);
            }
        }

        System.out.println(ret);
    }
}
