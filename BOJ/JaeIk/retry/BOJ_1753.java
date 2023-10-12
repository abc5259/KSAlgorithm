package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weigth;

    public Node(int end, int weight){
        this.end = end;
        this.weigth = weight;
    }

    //우선순위 큐에서 가중치가 작은 것부터 poll
    @Override
    public int compareTo(Node o) {
        return weigth - o.weigth;
    }
}

public class BOJ_1753 {
    static final int INF = 100_000_000;
    static List<Node>[] list;
    static int[] dist;
    static int V, E, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];

        dist = new int[V+1];

        Arrays.fill(dist, INF);

        for(int i=1; i<V+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        dijkstra(S);

        for(int i=1; i<=V; i++){
            if(dist[i] == INF)sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();

        boolean[] visited = new boolean[V+1];

        q.add(new Node(start, 0));

        dist[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int next = cur.end;

            if(visited[next])continue;

            visited[next] = true;

            for(Node node : list[next]){
                if(dist[node.end] > dist[next] + node.weigth){
                    dist[node.end] = dist[next] + node.weigth;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
