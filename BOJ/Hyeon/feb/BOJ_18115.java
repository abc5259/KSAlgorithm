package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int option = arr[i - 1];
            switch (option) {
                case 1:
                    deque.offerFirst(i);
                    break;
                case 2:
                    int tmp = deque.poll();
                    deque.offerFirst(i);
                    deque.offerFirst(tmp);
                    break;
                case 3:
                    deque.offerLast(i);
                    break;
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.poll()).append(" ");
        }
        System.out.println(sb);
    }
}


// S3 카드 놓기 덱
// 문제 이해 필요.
// 그냥 방법을 알면되는데 구현자체는 어렵지 않은데
// 자꾸 순서를 못 찾는다. 여러 테스트 케이스를 만들어보자.