package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
    static List<List<Integer>> map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new ArrayList<>();
            visited = new boolean[n+1];
            for(int i=0; i<=n; i++){
                map.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map.get(start).add(end);
                map.get(end).add(start);
            }

            int answer = 0;
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    answer++;
                    bfs(i);
                }
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<map.get(now).size(); i++){
                int next = map.get(now).get(i);

                if(visited[next])continue;

                visited[next] = true;
                queue.add(next);
            }
        }
    }
}
