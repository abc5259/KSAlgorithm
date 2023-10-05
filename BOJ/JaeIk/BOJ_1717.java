package BOJ.JaeIk;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){
                union(a,b);
            }
            else if(command == 1){
                sb.append((haveSameParent(a,b) ? "YES" : "NO") + "\n");
            }else{
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x){
        if(x == parent[x])return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y)parent[y]=x;
            else parent[x]=y;
        }
    }

    static boolean haveSameParent(int x, int y){
        x = find(x); y = find(y);

        if(x==y)return true;
        return false;
    }
}
