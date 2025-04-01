package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        int X;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push_front":
                    X = Integer.parseInt(st.nextToken());
                    deque.offerFirst(X);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    deque.offerLast(X);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
// S4 덱
// 개쉽게 풀었다.
// 그냥 Deque 자료구조를 활용한 메소드를 알아볼 수 있는 코드, 덱 자료구조는
// 맨 앞과 맨뒤에서 자유자재로 데이터를 넣고 뺄 수 있으며, 조회하고 삭제할 수 있기도하다.
// 맨 앞과 맨 뒤의 삽입 삭제시 시간복잡도는 O(1)이고 스택과 큐를 합친느낌이다.