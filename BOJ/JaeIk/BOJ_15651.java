package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
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
        //dfs를 이용해 중복이 가능한 모든 경우를 탐색한다
        for(int i=1; i<=n; i++){
            arr[depth] = i;
            solve(depth+1);
        }
    }
}
