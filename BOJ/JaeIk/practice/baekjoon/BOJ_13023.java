package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static boolean[] visited;
    static int answer;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        answer = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(answer == 0){
                dfs(i, 1);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int start, int depth){
        if(depth == 5){
            answer = 1;
            return;
        }

        visited[start] = true;

        for(int i=0; i<list.get(start).size(); i++){
            int next = list.get(start).get(i);

            if(!visited[next]){
                dfs(next, depth+1);
            }
        }

        visited[start] = false;
    }
}
