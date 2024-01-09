package BOJ.JaeIk.retry;

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>{
    int end;
    int weight;

    public Vertex(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return weight - o.weight;
    }
}

public class BOJ_1504 {
    static int INF = 200000000;
    static ArrayList<ArrayList<Vertex>> list;
    static int[] dist;
    static int N,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        //Arrays.fill(dist, INF);

        //양방향 인접 리스트
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Vertex(end, weight));

            list.get(end).add(new Vertex(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1=0;
        result1 += dijkstra(1,v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        int result2=0;
        result2 += dijkstra(1,v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int result = (result1>=INF && result2>=INF) ? -1 : Math.min(result1, result2);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static int dijkstra(int start, int end){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, INF);

        Arrays.fill(visited, false);

        pq.offer(new Vertex(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            int next = cur.end;

            if(!visited[next]){
                visited[next] = true;

                for(Vertex v : list.get(next)){
                    if(!visited[v.end] && dist[v.end]>dist[next]+v.weight){
                        dist[v.end] = dist[next]+v.weight;
                        pq.add(new Vertex(v.end, dist[v.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
