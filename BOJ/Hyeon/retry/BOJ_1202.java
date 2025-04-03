package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>(Comparator.comparingInt(o -> o.M));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.offer(new Jewel(m, v));
        }

        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            bag.offer(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Jewel> possible = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);

        long res = 0;

        while (!bag.isEmpty()) {
            int C = bag.poll();
            while (!jewels.isEmpty() && jewels.peek().M <= C) {
                possible.offer(jewels.poll());
            }

            if (!possible.isEmpty()) {
                res += possible.poll().V;
            }
        }
        System.out.print(res);
    }

    static class Jewel {
        private int M;
        private int V;

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }
    }
}

// G2 보석 도둑 정렬, 우선순위 큐
// 접근이나 이런걸 잘 정리하고 덤벼야되는 문제 같다 너무 성급하게 덤볐다
// 일단 로직 자체는 이해했으니 내일 복습하는게 나을 거 같다.