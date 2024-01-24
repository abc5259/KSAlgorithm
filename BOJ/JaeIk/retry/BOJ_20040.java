package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
    static boolean flag=false;
    static int count=0;
    static int[] parent;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            count++;

            if(!union(vertex1, vertex2)){
                flag=true;
                break;
            }
        }
        int answer = flag ? count : 0;
        System.out.println(answer);
    }

    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y)return false;
        parent[y]=parent[x];
        return true;
    }
}
