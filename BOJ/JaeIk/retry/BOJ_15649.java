package BOJ.JaeIk.retry;

import java.util.*;
import java.io.*;

public class BOJ_15649 {
    static StringBuilder sb = new StringBuilder();
    static Boolean[] visited;
    static int arr[];
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        visited = new Boolean[n];
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }

        solve(n, m, 0);

        System.out.println(sb);
    }

    static void solve(int n, int m, int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                //크기가 m인 arr를 미리 초기화하지 않고 동적으로 입력해주어야한다
                arr[depth] = i+1;
                solve(n, m, depth+1);
                visited[i]=false;
            }
        }
    }
}