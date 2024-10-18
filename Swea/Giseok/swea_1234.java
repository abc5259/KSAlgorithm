/**
 * 1234. [S/W 문제해결 기본] 10일차 - 비밀번호 (D3|스택) [O|00:09:18]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1234 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> q = new ArrayDeque<>();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            String nums = st.nextToken();

            for (int i = 0; i < length; i++) {
                if (q.isEmpty()) {
                    q.push(nums.charAt(i));
                    continue;
                }

                if (q.peek() == nums.charAt(i)) {
                    q.pop();
                    continue;
                }
                q.push(nums.charAt(i));
            }

            StringBuilder tmp = new StringBuilder();
            while (!q.isEmpty())
                tmp.append(q.poll());

            StringBuilder ret = new StringBuilder("#" + tc + " ");
            for (int i = tmp.length() - 1; i >= 0; i--)
                ret.append(tmp.charAt(i));

            System.out.println(ret);
        }
    }
}