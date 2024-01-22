package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775 {
    static int count=0;
    static int[] parent;
    static int g,p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        parent = new int[g+1];
        for(int i=1; i<=g; i++){
            parent[i] = i;
        }

        for(int i=1; i<=p; i++){
            int current = Integer.parseInt(br.readLine());
            int empty = find(current);

            if(empty==0)break;
            count++;
            union(empty, empty-1);
        }

        System.out.println(count);
    }

    static int find(int x){
        if(parent[x] == x)return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x<y)parent[y]=x;
            else{
                parent[x]=y;
            }
        }
    }
}
