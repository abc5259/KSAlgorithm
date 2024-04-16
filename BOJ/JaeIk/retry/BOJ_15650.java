package BOJ.JaeIk.retry;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[n+1];
        solve(n, m, 0);

        System.out.print(sb);
    }

    static void solve(int n, int m, int depth){
        if(depth == m){
            for(int i=0; i<depth; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        for(int i=1; i<=n; i++){
            if(depth>0){
                if(!visited[i] && i>arr[depth-1]){
                    visited[i] = true;
                    arr[depth] = i;
                    solve(n, m, depth+1);
                    visited[i] = false;
                }
            }
            else if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                solve(n, m, depth+1);
                visited[i] = false;
            }
        }
    }
}
