package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_2 {
    static int INF = 100_000_000;
    static List<GraphNode>[] graph;
    static boolean[] visited;
    static int[] table;
    static int v,e,v1,v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        visited = new boolean[v+1];
        graph = new List[v+1];
        for(int i=0; i<=v; i++){
            graph[i] = new ArrayList<>();
        }

        table = new int[v+1];


        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new GraphNode(end, weight));
            graph[end].add(new GraphNode(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int case1 = 0;
        case1 += dijkstra(1,v1);
        case1 += dijkstra(v1,v2);
        case1 += dijkstra(v2,v);

        int case2 = 0;
        case2 += dijkstra(1,v2);
        case2 += dijkstra(v2,v1);
        case2 += dijkstra(v1,v);

        int answer = (case1>=INF && case2>=INF) ? -1 : Math.min(case1, case2);

        System.out.println(answer);

    }

    static int dijkstra(int start, int end){
        PriorityQueue<GraphNode> pr = new PriorityQueue<>();
        //다익스트라 메서드를 여러번 호출하므로 호출할 떄마다 배열을 초기화 시켜줘야한다
        Arrays.fill(table, INF);
        Arrays.fill(visited, false);
        pr.offer(new GraphNode(start, 0));
        table[start] = 0;


        while(!pr.isEmpty()){
            GraphNode currentNode = pr.poll();
            int current = currentNode.next;

            if(visited[current])continue;
            visited[current]=true;

            for(GraphNode nextNode : graph[current]){
                if(!visited[nextNode.next] && table[nextNode.next] > table[current] + nextNode.weight){
                    table[nextNode.next] = table[current] + nextNode.weight;
                    pr.offer(new GraphNode(nextNode.next, table[nextNode.next]));
                }
            }
        }
        return table[end];
    }
}
