package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class GraphNode implements Comparable<GraphNode>{
    int next;
    int weight;

    public GraphNode(int next, int weight){
        this.next = next;
        this.weight = weight;
    }
    //o가 뭔지
    @Override
    public int compareTo(GraphNode o) {
        return weight - o.weight;
    }
}

public class BOJ_1753_2 {
    static int INF = 100_000_000;
    static List<GraphNode>[] graph;
    static boolean[] visited;
    static int[] table;
    static int v,e,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[v+1];
        graph = new List[v+1];
        for(int i=0; i<=v; i++){
            graph[i] = new ArrayList<>();
        }

        table = new int[v+1];
        for(int i=0; i<v+1; i++){
            table[i] = INF;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new GraphNode(end, weight));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++){
            if(table[i] == INF)sb.append("INF\n");
            else sb.append(table[i]+"\n");
        }

        System.out.println(sb);

    }

    static void dijkstra(int start){
        PriorityQueue<GraphNode> queue = new PriorityQueue<>();
        //오퍼, 애드 차이
        queue.offer(new GraphNode(start, 0));
        table[start] = 0;

        while(!queue.isEmpty()){
            GraphNode current = queue.poll();
            int next = current.next;

            if(visited[next])continue;
            visited[next] = true;

            for(GraphNode nextNode : graph[next]){
                if(table[nextNode.next] > table[next] + nextNode.weight){
                    table[nextNode.next] = table[next] + nextNode.weight;
                    queue.offer(new GraphNode(nextNode.next, table[nextNode.next]));
                }
            }
        }
    }
}
