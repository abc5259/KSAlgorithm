package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        solve(0);

        System.out.println(sb);
    }

    static void solve(int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(depth>0 && arr[depth-1]>i)continue;
            arr[depth] = i;
            solve(depth+1);
        }
    }
}
