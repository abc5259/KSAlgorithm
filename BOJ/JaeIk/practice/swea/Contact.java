package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            List<List<Integer>> map = new ArrayList<>();
            for(int i=0; i<101; i++){
                map.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map.get(start).add(end);
                Collections.sort(map.get(start));
            }

            List<Integer> result = bfs(map, s);

            int max = 0;
            for(int i=0; i<result.size(); i++){
                max = Math.max(max, result.get(i));
            }

            System.out.println("#"+(tc)+" "+max);
        }
    }

    static List<Integer> bfs(List<List<Integer>> map, int s){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[101];
        queue.add(s);
        int depth = 1;
        visited[s] = depth;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<map.get(now).size(); i++){
                int next = map.get(now).get(i);

                if(visited[next]>0)continue;

                visited[next] = visited[now] + 1;
                queue.add(next);
                depth = Math.max(depth, visited[next]);
            }
        }

        for(int i=0; i<101; i++){
            if(visited[i] == depth){
                result.add(i);
            }
        }

        return result;
    }
}
