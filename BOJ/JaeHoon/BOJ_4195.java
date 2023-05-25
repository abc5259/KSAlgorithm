package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[200001];
            for(int i=0; i<=200000; i++) parent[i] = i;

            Map<String,Integer> map = new HashMap<>();
            Map<Integer,Integer> result = new HashMap<>();
            int n = 1;
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(!map.containsKey(friend1)) {
                    map.put(friend1,n);
                    result.put(n,1);
                    n++;
                }
                if(!map.containsKey(friend2)) {
                    map.put(friend2,n);
                    result.put(n,1);
                    n++;
                }

                int a = map.get(friend1);
                int b = map.get(friend2);
                int aRoot = find(a);
                int bRoot = find(b);

                if(aRoot != bRoot) {
                    int sum = result.get(aRoot) + result.get(bRoot);

                    union(a,b);
                    int num = find(a);
                    result.put(num,sum);

                    sb.append(sum+"\n");
                }else {
                    sb.append(result.get(aRoot)+"\n");
                }

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

        if(x != y) {
            if(x <= y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
