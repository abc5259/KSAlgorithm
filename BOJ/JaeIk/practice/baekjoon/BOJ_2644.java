package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int result = -1;
    static List<Integer>[] relation;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(br.readLine());

        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            relation[parent].add(child);
            relation[child].add(parent);
        }

        dfs(x,y,0);

        System.out.println(result);
    }

    static void dfs(int start, int end, int depth){
        if(start==end){
            result = depth;
            return;
        }

        visited[start] = true;
        for(int i=0; i<relation[start].size(); i++){
            int next = relation[start].get(i);
            if(!visited[next]){
                dfs(next, end, depth+1);
            }
        }
    }
}
