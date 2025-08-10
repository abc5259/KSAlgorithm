package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
            if (!deque.isEmpty()) {
                deque.offerLast(deque.pollFirst());
            }
        }
        System.out.println(sb);
    }
}
// S5 카드1 덱
// 오퍼라스트, 폴퍼스트를 활용