package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (n-- > 0) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            boolean err = false;
            for (char command : p) {
                if (command == 'R') {
                    flag = !flag;
                } else {
                    if (deque.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (flag) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (err) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(flag ? deque.pollFirst() : deque.pollLast());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}

// G5 AC DEQUE
// 메모리 초과
