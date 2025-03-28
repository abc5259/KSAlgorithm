package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] p = br.readLine().toCharArray();

            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            String[] split = str.substring(1, str.length() - 1).split(",");

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(split[i]));
            }

            boolean flag = true;
            boolean err = false;
            for (int i = 0; i < p.length; i++) {
                if (!deque.isEmpty()) {
                    if (p[i] == 'R') {
                        flag = !flag;
                    } else {
                        if (flag) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                } else {
                    err = true;
                    break;
                }
            }
            if (err) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (deque.size() != 1) {
                    if (flag) {
                        sb.append(deque.pollFirst()).append(",");
                    } else {
                        sb.append(deque.pollLast()).append(",");
                    }
                }
                sb.append(deque.poll()).append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
