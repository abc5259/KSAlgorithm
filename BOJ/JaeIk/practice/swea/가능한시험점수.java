package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class 가능한시험점수 {
    static int[] arr;
    static boolean[][] visited;
    static int N;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum=0;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            visited = new boolean[N+1][sum+1];

            dfs(0, 0);

            int answer = 0;
            for(int i=0; i<sum+1; i++){
                if(visited[N][i])answer++;
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void dfs(int depth, int sum){
        if(visited[depth][sum])return;
        visited[depth][sum] = true;

        if(depth == N)return;

        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);
    }
}