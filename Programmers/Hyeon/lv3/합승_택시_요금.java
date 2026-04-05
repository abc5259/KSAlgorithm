package Programmers.Hyeon.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 합승_택시_요금 {

    class Solution {
        int n;
        List<Node>[] adj;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int[] row : fares) {
                int from = row[0];
                int to = row[1];
                int cost = row[2];

                adj[from].add(new Node(to, cost));
                adj[to].add(new Node(from, cost));
            }
            this.n = n;

            int[] fromS = dijkstra(s);
            int[] fromA = dijkstra(a);
            int[] fromB = dijkstra(b);

            int min = fromS[a] + fromS[b];

//            for (int i = 1; i <= n; i++) {
//                int tmp = fromS[i];
//
//                int[] fromI = dijkstra(i);
//
//                tmp += fromI[a] + fromI[b];
//
//                min = Math.min(min, tmp);
//            }
            for (int i = 1; i <= n; i++) {
                min = Math.min(min, fromS[i] + fromA[i] + fromB[i]);
            }
            return min;
        }

        private int[] dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] cost = new int[n + 1];
            Arrays.fill(cost, 20_000_000);
            cost[start] = 0;
            pq.offer(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cost[cur.v] < cur.w) {
                    continue;
                }

                for (Node next : adj[cur.v]) {
                    if (cost[next.v] > cur.w + next.w) {
                        cost[next.v] = cur.w + next.w;
                        pq.offer(new Node(next.v, cost[next.v]));
                    }
                }
            }
            return cost;
        }

        private class Node implements Comparable<Node> {
            int v;
            int w;

            Node(int v, int w) {
                this.v = v;
                this.w = w;
            }

            @Override
            public int compareTo(Node node) {
                return this.w - node.w;
            }
        }
    }
}
// lv3 합승 택시 요금 다익스트라
// 24분
// 2021 KAKAO BLIND RECRUITMENT 에서 다익스트라가 나오는데
// 일단 fromS 부터 A 와 B 까지의 다익스트라에 대한 값이 최대값이다 이보다 더 적게 비용을 지불하는 합승 구간을 찾아야하는데
// 그럼 넓게 보면 S -> ??? -> A + S -> ??? -> B 의 합이 합승구간인 ??? 의 총 비용이다
// 그래서 ??? 를 어떻게구할까 했는데 특정한 최단경로를 고려했을 때 우리가
// 2가지로 했는데 지금은 n개의 노드가있어서 그렇게 2개로 분리가 안되었다
// 그래서 반복문을 통해서 i가 합승 종료 구간이라고 판단해서 i까지의 다익스트라와
// i부터 시작한 다익스트라로 A , B 의 도착지점에 대한 값으로 최대값과 최소 연산을 했다.
// 개선된 풀이
// 양방향 이니까 A에서 B 나 B에서 A의 요금이 같아서 출발을 죄다 S, A, B로 잡은 다익스트라 3개를 가지고.
// 셋다 합류지점까지의 비용을 고려하면된다 S-> i 합승, i -> A 각자 , i -> B 각자로 하면
// 그냥 S 출발, A 출발 , B 출발인데 모두 i 로 간다.