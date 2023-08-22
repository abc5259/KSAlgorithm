package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        int[] arr = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt-1; j++) {
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                arr[v2]++;
                v1 = v2;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(arr[i] == 0) q.offer(i);
        }
        StringBuffer sb = new StringBuffer();
        int total = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            total++;
            sb.append(curr+"\n");

            for(int next:graph.get(curr)) {
                arr[next]--;
                if(arr[next] == 0) q.offer(next);
            }
        }

        System.out.println(total == N ? sb : 0);
    }
}
//6 3
//3 1 4 3
//4 6 2 5 4
//2 3 2