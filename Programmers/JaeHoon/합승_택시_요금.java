package Programmers.JaeHoon;
import java.util.*;

public class 합승_택시_요금 {

class Solution {
    ArrayList<ArrayList<Node>> graph;
    class Node {
        int v,cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<fares.length; i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];
            graph.get(v1).add(new Node(v2,cost));
            graph.get(v2).add(new Node(v1,cost));
        }
        int[] dist = new int[n+1];
        dijkstra(s,n,dist);

        answer = dist[a] + dist[b];
        
        for(int i=1; i<=n; i++) {
            int sameDist = dist[i];
            int[] d = new int[n+1];
            dijkstra(i,n,d);
            answer = Math.min(answer,sameDist + d[a] + d[b]);
        }
        
        // System.out.println(Arrays.toString(dist));
        
        return answer;
    }
    public void dijkstra(int start, int n,int[] dist) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
        
        q.offer(new Node(start,0));
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(dist[curr.v] < curr.cost) continue;
            
            for(Node next:graph.get(curr.v)) {
                
                if(dist[next.v] > curr.cost + next.cost) {
                    dist[next.v] = curr.cost + next.cost;
                    q.offer(new Node(next.v,dist[next.v]));
                }
            }
        }
    }
}
}
