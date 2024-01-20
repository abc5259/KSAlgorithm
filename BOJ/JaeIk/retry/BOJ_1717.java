package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(command==0){
                union(x, y);
            }
            if(command==1){
                String answer = isSameParent(x, y) ? "yes" : "no";
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int x){
        if(x==parent[x])return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y){
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return true;
        }
        return false;
    }
}
