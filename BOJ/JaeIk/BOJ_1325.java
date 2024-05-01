package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.get(start).add(end);
        }

        answer = new int[n+1];
        for(int i=1; i<=n ; i++){
            bfs(map, n, i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n ; i++){
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(answer[i] == max){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(List<List<Integer>> map, int n, int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i=0; i<map.get(nowNode).size(); i++){
                int nextNode = map.get(nowNode).get(i);

                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    answer[nextNode]++;
                    queue.add(nextNode);
                }
            }
        }
    }
}
