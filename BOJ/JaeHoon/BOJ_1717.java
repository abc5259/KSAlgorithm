package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int N,M;
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=0; i<=N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(n == 0) { // 합집합 연산
                union(a,b);
            }
            if(n == 1) { // 두 원소가 같은 집합인지
                if(find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(rank[x] < rank[y]) {
            parent[x] = y;
            rank[y] += rank[x];
        }
        else {
            parent[y] = x;
            rank[x] += rank[y];
        }

    }
}
