package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_20040 {
    static int N, M, result, parents[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a, b)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean union(int a, int b) {
        int a_root = find(a);
        int b_Root = find(b);

        if(a_root == b_Root) return false;
        parents[b_Root] = a_root;
        return true;
    }

    private static int find(int n) {
        if(n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

}
