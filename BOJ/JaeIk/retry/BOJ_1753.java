package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n){
        return weight - n.weight;
    }
}

public class BOJ_1753 {
    static final int INF = 100_000_000;

    //다음 정점정보가 들어있는 리스트들의 배열
    static List<Node>[] list;
    static int[] dist;
    static int V,E,S;
    static int u,v,e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(br.readLine());

        //정점정보저장을 위한 리스트
        list = new ArrayList[V+1];

        //최단 거리 업데이트를 위한 배열
        dist = new int[V+1];

        //거리 업데이트를 위한 배열을 가장 큰 수로 초기화
        Arrays.fill(dist, INF);

        //정점정보를 위한 리스트에 어레이리스트 생성
        for(int i=1; i<V+1; i++){
            list[i] = new ArrayList<>();
        }

        //리스트에 정점의 시작을 인덱스로하여 끝과 가중치를 업데이트해줌
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            //리스트에 정점과 연결된 다른 정점들의 정보들을 넣어준다
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

        //방문여부를 위한 불리언 배열
        boolean[] visited = new boolean[V+1];

        //시작정점을 우선순위 큐에 넣어줌
        q.add(new Node(start, 0));

        //시작 -> 시작 정점의 최단 거리는 0
        dist[start] = 0;

        while(!q.isEmpty()){
            Node curNode = q.poll();

            //현재 정점을 업데이트 해줌
            int cur = curNode.end;
            
            //현재 정점이 방문되어있다면 넘어감
            if(visited[cur])continue;
            //방문 하지 않았다면 방문 표시
            visited[cur] = true;
            
            for(Node node : list[cur]){
                //연결되어있는 각 노드들에 대하여 계산 후 최단 거리를 갱신
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    //다음노드의 정보를 우선 순위 큐에 넣어준다
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
