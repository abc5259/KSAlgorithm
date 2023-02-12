package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
    public static int N, K;
    public static int ans;
    public static boolean[] visited;
    public static int[] weightGain;

    public static void workout(int depth, int total) {
        if (total >= 500) {
            if (N == depth) {
                ans += 1;
                return;
            }
        } else {
            return;
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                workout(depth+1, total-K + weightGain[i]);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weightGain = new int[N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++)
            weightGain[i] = Integer.parseInt(st.nextToken());

        workout(0, 500);
        System.out.println(ans);
    }
}
