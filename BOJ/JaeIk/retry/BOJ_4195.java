package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] level;
    static int[] parent;
    static int T,F;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int F = Integer.parseInt(br.readLine());

            parent = new int[F*2];
            level = new int[F*2];

            for(int i=0; i<F*2; i++){
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;

            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<F; i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!map.containsKey(a)){
                    map.put(a,idx++);
                }

                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                sb.append(union(map.get(a), map.get(b)) + "\n");
            }
        }

        System.out.println(sb);

    }

    static int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }

        return level[x];
    }

}
