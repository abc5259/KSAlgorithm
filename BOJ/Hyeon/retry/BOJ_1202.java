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

        PriorityQueue<Jewel> jewels = new PriorityQueue<>((o1, o2) -> o1.M - o2.M);

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
// 일단 보석의 개수와, 가방의 개수가 30만개이다. 이는 N^2의 시간복잡도로 정렬하면 시간초과가 발생하기 떄문에
// NlogN의 시간복잡도를 가진 것으로 정렬하는 것이 좋다. 이때 내가 담을 수 있는 가장 최고의 가치를 담기 떄문에
// 그리디에서 내가 원하는 가장 값어치 높은 거로 정렬도 해야된다.
// 그렇다면 보석을 담을 때 가장 무게가 적은 거부터 담고, 가방도 작은거부터 담는다. 그래서 가장 낮은 무게의 가방을
// 꺼냈을 때 나보다 작은 무게를 가진 보석의 우선순위 큐에서 뽑아와서 가치를 내림차순 하는 우선순위로 가져와서 누적합한다.