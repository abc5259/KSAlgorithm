package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_1940_2 {
    private static int[] materials;
    private static int ans = 0;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        materials = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    private static void swap(int n1, int n2) {
        int tmp = materials[n1];
        materials[n1] = materials[n2];
        materials[n2] = tmp;
    }

    public static void dfs(int now, int sum, int cnt) {
        if (cnt == 2) {
            if (sum == m) {
                ans++;
                return;
            }

            return;
        }

        for (int i = now; i < n; i++) {
            swap(i, now);
            dfs(i+1, sum + materials[now], cnt+1);
            swap(i, now);
        }
    }
}
