package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int[] src;
    static int[] tmp;

    static boolean[] select;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tmp = new int[M];
        select = new boolean[N];
        src = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = i + 1;
        }
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int idx) {
        if (idx == tmp.length) {
            for (int i = 0; i < tmp.length; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (select[i])
                continue;
            tmp[idx] = src[i];

            select[i] = true;
            perm(idx + 1);
            select[i] = false;
        }
    }
}
