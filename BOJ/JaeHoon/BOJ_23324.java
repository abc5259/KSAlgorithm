package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_23324 {
    static int N,M,K;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(i == K) continue;

            union(v1,v2);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            int root = find(i);

            map.put(root, map.getOrDefault(root,0) + 1);
        }

        long answer = 0;
        if(map.size() != 1) {
            answer = 1;
            for( Map.Entry<Integer, Integer> elem : map.entrySet() ){
                answer *= elem.getValue();
            }
        }

        System.out.println(answer);


    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x <= y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
