package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_20301 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        boolean roll = false;
        int cnt = 0;
        while (!deque.isEmpty()) {
            if (roll) {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                sb.append(deque.pollLast()).append("\n");
            } else {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                sb.append(deque.pollFirst()).append("\n");
            }
            cnt++;

            if (cnt % M == 0) {
                if (roll) {
                    roll = false;
                } else {
                    roll = true;
                }
            }
        }
        System.out.println(sb);
    }
}

// S3 반전 요세푸스 덱
// 그냥 요세푸스 문제에서 반대방향으로 돌리는것만 추가적인 요소
// 반대방향은 플래그와 cnt를 통해서 cnt 마다 플래그를 변하게 조건문을 만들었고 pollFirst와 pollLast를 적절하게 사용했다.