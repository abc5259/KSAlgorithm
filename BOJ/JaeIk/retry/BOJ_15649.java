package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static boolean[] visited;
    static StringBuilder sb;
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        solve(0);

        System.out.println(sb);
    }

    static void solve(int depth){
        if(depth==m){
            for(int number : arr){
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                solve(depth+1);
                visited[i]=false;
            }
        }
    }
}
