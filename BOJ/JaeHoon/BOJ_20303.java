package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_20303 {

    static int N, M, K;
    static int[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        Map<Integer, Bag> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            int root = find(i);
            if(map.containsKey(root)) {
                Bag bag = map.get(root);
                bag.v += arr[i];
                bag.w++;
            }else {
                map.put(root, new Bag(1, arr[i]));
            }
        }

        List<Bag> bags = map.values()
                .stream()
                .collect(Collectors.toList());
        int[][] dp = new int[K][bags.size()];
        for(int j=0; j<bags.size(); j++) {
            Bag bag = bags.get(j);
            for(int i=1; i<K; i++) {
                if(i-bag.w >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-bag.w][j-1] + bag.v);
                }else if(j-1 >= 0 && i >= bag.w){
                    dp[i][j] = Math.max(dp[i][j-1], bag.v);
                }
                else if(j-1 >= 0) {
                    dp[i][j] = dp[i][j-1];
                }
                else if(i >= bag.w){
                    dp[i][j] = bag.v;
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(dp[K-1][bags.size()-1]);
    }

    static class Bag {
        int w,v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return;
        }
        if(x < y) {
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }
    }
}
