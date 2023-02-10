package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void backtrack(int num, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < cnt; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = num; i < N+1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                backtrack(i, cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited = new boolean[N+1];
        arr = new int[M];

        backtrack(1, 0);
        System.out.println(sb);
    }
}