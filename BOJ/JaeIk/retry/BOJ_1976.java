package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int[] parent;
    static int[][] graph;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input==1)union(i, j);
            }
        }
        String result="YES";
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++){
            int current = Integer.parseInt(st.nextToken());

            if(start != find(current))result="NO";
        }
        System.out.println(result);
    }

    static int find(int x){
        if(parent[x] == x)return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y)parent[y] = x;
            else parent[x] = y;
        }
    }
}
