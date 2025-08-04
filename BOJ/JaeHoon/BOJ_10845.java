package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_10845 {

    public static void main(String[] args) throws IOException {
        //02:05
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                deque.addFirst(n);
            }
            else if(s.equals("pop")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(deque.removeLast()).append("\n");
                }
            }
            else if(s.equals("size")) {
                sb.append(deque.size()).append("\n");
            }
            else if(s.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }
            else if(s.equals("front")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
            else if(s.equals("back")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
