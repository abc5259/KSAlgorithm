package BOJ.JaeIk.retry;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BOJ_13549 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //우선순위 큐를 시간 오름차순으로 설정
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1]-y[1]);
        pq.offer(new int[]{N, 0});
        boolean[] visited = new boolean[100_001];
        int count = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int nNode = now[0];
            count = now[1];

            if(nNode == K)break;

            visited[nNode] = true;

            if(nNode*2 <= 100_000 && !visited[nNode*2]){
                pq.offer(new int[]{nNode*2, count});
            }

            if(nNode<K && nNode+1<=100_000 && !visited[nNode+1]){
                pq.offer(new int[]{nNode+1, count+1});
            }

            if(nNode-1>=0 && !visited[nNode-1]){
                pq.offer(new int[]{nNode-1, count+1});
            }
        }

        System.out.println(count);
    }
}