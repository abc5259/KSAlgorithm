package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        int[] arr = new int[N+1];
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v2]++;
            graph.get(v1).add(v2);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(arr[i] == 0) q.offer(i);
        }
        StringBuffer sb = new StringBuffer();
        while (!q.isEmpty()) {
            int curr =q.poll();
            sb.append(curr + " ");
            for(int next:graph.get(curr)) {
                arr[next]--;
                if(arr[next] == 0) q.offer(next);
            }
        }

        System.out.println(sb);

    }
}
//4 3
//1 3
//2 4
//1 2