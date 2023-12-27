package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_22480 {
    static ArrayList<ArrayList<Integer>> graph ;
    static int[] visited;
    static int rank = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n+1];

        graph = new ArrayList<>();
        for(int i=0; i<=n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(r);

        for(int i=1; i<=n; i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int vertex){
        visited[vertex] = rank;

        for(int newVertex : graph.get(vertex)){
            if(visited[newVertex] == 0){
                rank++;
                dfs(newVertex);
            }
        }
    }
}
