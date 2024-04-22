package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664 {
    static StringBuilder sb;
    static int[] part;
    static int[] arr;
    static boolean[] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        part = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sb = new StringBuilder();

        dfs(0, -1);

        System.out.print(sb);
    }

    static void dfs(int depth, int foreIdx){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(part[i]+" ");
            }
            sb.append("\n");
            return;
        }

        int foreNum=0;
        for(int i=foreIdx+1; i<n; i++){
            if(!visited[i] && arr[i]!=foreNum){
                visited[i] = true;
                foreNum = arr[i];
                part[depth] = arr[i];
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }
}
