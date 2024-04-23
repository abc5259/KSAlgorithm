package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666 {
    static boolean[] visited;
    static StringBuilder sb;
    static int[] part;
    static int[] arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];
        part = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sb = new StringBuilder();

        dfs(0, 0);

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
        for(int i=foreIdx; i<n; i++){
            if(arr[i]!=foreNum){
                foreNum = arr[i];
                part[depth] = arr[i];
                dfs(depth+1, i);
            }
        }
    }
}
