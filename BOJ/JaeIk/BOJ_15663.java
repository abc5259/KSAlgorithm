package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15663 {
    static boolean[] visited;
    static int[] arr;
    static int[] part;
    static StringBuilder sb = new StringBuilder();;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        part = new int[m];


        solve(0);

        System.out.print(sb);

    }

    static void solve(int depth){
        if(depth == m){
            for(int i=0; i<depth; i++){
                sb.append(part[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int foreNum=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(foreNum != arr[i]) {
                    visited[i] = true;
                    part[depth] = arr[i];
                    foreNum = arr[i];
                    solve(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
