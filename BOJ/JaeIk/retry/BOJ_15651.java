package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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

            return;
        }

        for(int i=1; i<=n; i++){
            arr[depth] = i;
            solve(n, m, depth+1);
        }
    }
}
