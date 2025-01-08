/**
 * [S2 스택] 1874 - O, 00:27:09
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Deque<Integer> stk = new ArrayDeque<>();

        int num = 1;
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] >= num) {
                for (; num <= nums[idx]; num++) {
                    stk.push(num);
                    sb.append("+").append("\n");
                }
            }

            if (nums[idx] == stk.peek()) {
                stk.pop();
                sb.append("-").append("\n");
            }
        }

        if (!stk.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
