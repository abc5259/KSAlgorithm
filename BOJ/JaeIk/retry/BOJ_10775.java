package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775 {
    static int[] parent;
    static int G,P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for(int i=1; i<=G; i++){
            parent[i] = i;
        }

        int res=0;
        for(int i=0; i<P; i++){
            int g = Integer.parseInt(br.readLine());
            int empty = find(g);

            if(empty == 0)break;

            res++;

            union(empty, empty-1);
        }

        System.out.println(res+"\n");
    }

    static int find(int x){
        if(x==parent[x])return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y)parent[x] = y;
    }
}
