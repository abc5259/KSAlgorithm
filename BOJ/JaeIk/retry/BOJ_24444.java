package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24444 {
    static int n;
    static int m;
    static int r;
    static int[] check;
    static int rank=1;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        check = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
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
            Collections.sort(graph.get(i));
        }

        bfs(r);

        for(int i=1; i<=n; i++){
            System.out.println(check[i]);
        }
    }

    static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        check[vertex] = rank++;


        while(!queue.isEmpty()){
            int standardVertex = queue.poll();

            for(int newVertex : graph.get(standardVertex)){
                if(check[newVertex] == 0){
                    queue.offer(newVertex);
                    check[newVertex] = rank++;
                }
            }
        }

    }
}
