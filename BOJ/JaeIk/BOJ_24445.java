package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24445 {
    static int[] sequence;
    static int count = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        sequence = new int[n+1];
        check = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=0; i<graph.size(); i++){
            graph.get(i).sort(Collections.reverseOrder());
        }

        bfs(r);

        for(int i=1; i<=n; i++){
            System.out.println(sequence[i]);;
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;
        sequence[start] = ++count;

        while(!q.isEmpty()){
            int curNode = q.poll();

            for(int nextNode : graph.get(curNode)){
                if(!check[nextNode]){
                    sequence[nextNode] = ++count;
                    check[nextNode] = true;
                    q.offer(nextNode);
                }
            }
        }
    }
}
