package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

public class 장훈이의높은선반 {
    static List<Integer> list;
    static boolean[] visited;
    static int n, b;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];

            list = new ArrayList<>();
            dfs(0, 0, -1);
            Collections.sort(list);

            System.out.println("#"+(tc+1)+" "+list.get(0));
        }
    }

    static void dfs(int depth, int sum, int foreIdx){
        if(depth == n) {
            if (sum >= b) {
                list.add(sum - b);
            }
            return;
        }

        if(sum >= b){
            list.add(sum-b);
            return;
        }

        for(int i=foreIdx+1; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, sum+arr[i], i);
                visited[i] = false;
            }
        }
    }
}
