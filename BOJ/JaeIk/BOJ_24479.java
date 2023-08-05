package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int check[];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        check = new int[n+1];
        
        //graph 리스트 인덱스 유의
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

        for(int i=1; i<graph.size(); i++){
            Collections.sort(graph.get(i));
        }

        dfs(r);

        for(int i=1; i<check.length; i++){
            sb.append(check[i]).append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int vertex){
        check[vertex] = count;

        for(int i=0; i<graph.get(vertex).size(); i++){
            int newVertex = graph.get(vertex).get(i);

            if(check[newVertex]==0){
                count++;
                dfs(newVertex);
            }
        }
    }
}
