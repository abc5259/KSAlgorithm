package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        check = new int[n+1];

        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        count = 1;

        //정렬을 하는이유는?
        for(int i=0; i< graph.size(); i++){
            Collections.sort(graph.get(i));
        }

        bfs(r);

        for(int i=1; i<n+1; i++){
            sb.append(check[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int vertex){
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        check[vertex] = count++;

        while(!q.isEmpty()){
            int a = q.poll();

            for(int i=0; i< graph.get(a).size(); i++){
                int nextVertex = graph.get(a).get(i);

                if(check[nextVertex]==0){
                    q.offer(nextVertex);
                    check[nextVertex]=count++;
                }
            }
        }
    }
}
