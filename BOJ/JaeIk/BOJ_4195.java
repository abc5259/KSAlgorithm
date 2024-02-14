package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static int[] parent;
    static int[] level;
    static int n, f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<n; i++){
            f = Integer.parseInt(br.readLine());
            parent = new int[f*2];
            level = new int[f*2];

            for(int k=0; k<f*2; k++){
                parent[i]=i;
                level[i]=1;
            }

            for(int j=0; j<f; j++){
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();


            }
        }
    }

    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y)parent[y]=x;
            else {
                parent[x]=y;
            }
        }
    }
}
