package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        dfs(n,m,0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth){
        if(depth==m){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            //depth가 0보다 클때가 아니라면 ArrayIndexOutOfBoundsException 발생
            if(depth>0 && arr[depth-1]>i+1)continue;
            if(!visited[i]){
                visited[i]=true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visited[i]=false;
            }
        }
    }
}
