package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder bfs_sb = new StringBuilder();
    static StringBuilder dfs_sb = new StringBuilder();
    static boolean[] b_visited;
    static boolean[] d_visited;
    static int[][] arr;
    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        b_visited = new boolean[N+1];
        d_visited = new boolean[N+1];
        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[f][b] = arr[b][f] = 1;
        }

        dfs(V);
        bfs(V);

        System.out.println(dfs_sb+"\n"+bfs_sb);
    }

    static void dfs(int in){
        s.push(in);
        dfs_sb.append(in).append(" ");
        d_visited[in] = true;

        while(!s.isEmpty()){
            int temp = s.pop();

            for(int i=1; i<=N; i++){
                if(d_visited[i]==false && arr[temp][i]==1){
                    dfs(i);
                }
            }
        }
    }

    static void bfs(int in){
        q.offer(in);
        bfs_sb.append(in).append(" ");
        b_visited[in] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=1; i<=N; i++){
                if(b_visited[i]==false && arr[temp][i]==1){
                    q.offer(i);
                    b_visited[i] = true;
                    bfs_sb.append(i).append(" ");
                }
            }
        }
    }
}
