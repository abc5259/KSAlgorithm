package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int idx = i + 1;
            int num = Integer.parseInt(st.nextToken());
            deque.offer(new int[]{idx, num});
        }

        int cnt = 0;
        while (!deque.isEmpty()) {
            if (0 < cnt) {
                while (cnt-- > 1) {
                    deque.offer(deque.pollFirst());
                }
            } else {
                while (cnt++ < 0) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            sb.append(deque.peek()[0]).append(" ");
            cnt = deque.peek()[1];

            deque.pollFirst();
        }
        System.out.println(sb);
    }
}

// S3 풍선 터뜨리기 덱
// 방식은 이해하는데 자꾸 논리적 오류를 범한다.
// 널포인터 에러 주의, 그리고 poll 했을 경우 해당 자료구조에는 인덱스의 개수가 변하기 때문에 이를
// 따로 저장해서 노드처럼 사용해야한다.
// 빼고 넣고에 대한 방식은 이해하지만, deque가 비어있을 때 기저조건도 살펴야하고, peek해서 poll하지 않게도 적용한다.