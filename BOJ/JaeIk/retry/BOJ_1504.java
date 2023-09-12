package BOJ.JaeIk.retry;


import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int end;
    int weight;

    public Point(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point p) {
        return weight - p.weight;
    }
}
public class BOJ_1504 {
    static boolean[] visited;
    static int INF = 200_000_000;
    static int[] dist;
    static List<Point>[] list;
    static int N, E;
    static int a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Point(b, c));
            //무방향그래프
            list[b].add(new Point(a, c));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int require1 = Integer.parseInt(st.nextToken());
        int require2 = Integer.parseInt(st.nextToken());

        int answer = solve(require1, require2);
        bw.write(answer+ "\n");

        bw.close();
        br.close();
    }

    static int solve(int req1, int req2){
        int result1 = 0;
        int result2 = 0;

        result1 += dijkstra(1, req1);
        result1 += dijkstra(req1, req2);
        result1 += dijkstra(req2, N);

        result2 += dijkstra(1, req2);
        result2 += dijkstra(req2, req1);
        result2 += dijkstra(req1, N);

        // 경로1 && 경로2 -> 가는길이 없는 경우
        if(result1 >= INF && result2 >= INF) return -1;
        else return Math.min(result1, result2);
    }

    static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Point curPoint = pq.poll();

            int cur = curPoint.end;
            int curWeight = curPoint.weight;

            if(visited[cur]==true)continue;
            visited[cur] = true;

            for(int i=0; i<list[cur].size(); i++){
                int nextPoint = list[cur].get(i).end;
                int nextWeight = list[cur].get(i).weight;

                if(!visited[nextPoint] && dist[nextPoint]>curWeight+nextWeight){
                    dist[nextPoint] = curWeight + nextWeight;
                    pq.add(new Point(nextPoint, dist[nextPoint]));
                }
            }
        }
        return dist[end];
    }
}
