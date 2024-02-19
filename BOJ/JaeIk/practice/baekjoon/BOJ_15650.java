package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static StringBuilder sb;
    static boolean[] visited;
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[m];
        sb = new StringBuilder();

        solve(0);

        System.out.println(sb);;
    }

    static void solve(int depth){
        if(depth==m){
            for(int element : arr){
                sb.append(element).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(depth>0 && arr[depth-1]>i+1)continue;

            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                solve(depth+1);
                visited[i] = false;
            }
        }
    }
}
