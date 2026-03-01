package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779 {
    static int n;
    static List<Node>[] adj;
    static int[] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        trace = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

        Deque<Integer> path = new ArrayDeque<>();

        int cur = end;
        while (cur != start) {
            path.push(cur);
            cur = trace[cur];
        }
        path.push(start);

        System.out.println(path.size());

        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] price = new int[n + 1];
        Arrays.fill(price, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        price[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > price[cur.v]) {
                continue;
            }

            if (cur.v == end) {
                return cur.w;
            }

            for (Node next : adj[cur.v]) {
                if (price[next.v] > cur.w + next.w) {
                    price[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, price[next.v]));
                    trace[next.v] = cur.v;
                }
            }
        }
        return price[end];
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}
// G3 최소비용 구하기 2 다익스트라, 역추적
// 32분
// 어떻게든 스택 안쓰고 풀어보려고 역추적을 설계하면서 StringBuilder 의 sb.reverse 도 해보고 고려해봤는데
// 그래도 스택말고 방법이 없는거 같았다. stack 사이즈가 1000이면 너무 깊을 거 같은 우려
// 가중치가 다르고 가장 최단 경로 비용을 구하기에 다익스트라를 염두해두고 Node 는 PQ의 가중치 오름차순으로 쓰기위해
// Comparable 구현 함
// trace 역추적 배열로 현재의 노드가 어디서 부터 입력되었는지를 추적하고 이를 이용해서
// while(cur!=start) 로 stack 에 넣는다 cur 은 현재기준 end 이다
// 이를 대입해가면서 stack 에 넣고 경로의 대한 개수를 stack.size 스택은 역추적으로 해서 문자열로 출력한다.

// 근데 생각해보니 자료구조 스택은 상관없지 사이즈는 힙메모리잖아 재귀의 스택이나 JVM 스택오버플로우 걱정하지