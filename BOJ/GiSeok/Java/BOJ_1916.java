package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    static public ArrayList<ArrayList<int[]>> graph;
    static public PriorityQueue<int[]> q;
    static public int N, M, startNode, endNode;

    static public int Dijkstra() {
        q = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        int[] track = new int[N+1];
        for (int i = 0; i < N+1; i++)
            track[i] = Integer.MAX_VALUE;

        q.add(new int[]{startNode, 0});
        track[startNode] = 0;

        while (!q.isEmpty()) {
            int[] vw = q.poll();

            if (track[vw[0]] < vw[1])
                continue;

            for (int i = 0; i < graph.get(vw[0]).size(); i++) {
                int[] e = graph.get(vw[0]).get(i);
                if (track[e[0]] > vw[1] + e[1]) {
                    track[e[0]] = vw[1] + e[1];
                    q.add(new int[]{e[0], track[e[0]]});
                }
            }
        }
        return track[endNode];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++)
            graph.add(new ArrayList<int[]>());
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(n1).add(new int[]{n2, w});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        System.out.println(Dijkstra());
    }
}