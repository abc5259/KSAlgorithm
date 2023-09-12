package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static boolean[] visited;
    static int cnt = 0;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] connect;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        connect = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[f][b] = connect[b][f] = 1;
        }

        bfs(1);

        System.out.println(cnt);

    }

    static void bfs(int input){
        q.offer(input);
        visited[input] = true;

        while(!q.isEmpty()){
            int val = q.poll();

            for(int i=1; i<=N; i++){

                if(visited[i]==false && connect[val][i]==1){
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

    }
}
