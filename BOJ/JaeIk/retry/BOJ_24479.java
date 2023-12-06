package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.text.html.ListView;

public class BOJ_24479{
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        for(int i=0; i<=n+1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=1; i<n+1; i++){
            Collections.sort(graph.get(i));
        }

        rank = 1;
        dfs(r);

        for(int i=1; i<n+1; i++){
            System.out.println(visited[i]);
        }

    }

    static void dfs(int vertex){
        visited[vertex] = rank;

        for(int nextVertex : graph.get(vertex)){
            if(visited[nextVertex]==0){
                rank++;
                dfs(nextVertex);
            }
        }
    }

}