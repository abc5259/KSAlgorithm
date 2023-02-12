package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    public static int L, C;
    public static String[] aeiou = {"a", "e", "i", "o", "u"};
    public static String[] stream;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void makePassword(int depth, int idx) {
        if (depth == L) {
            String s = "";
            for (int i = 0; i < C; i++) {
                if (visited[i])
                    s += stream[i];
            }

            int cnt = 0;
            for (String v : aeiou) {
                if (s.contains(v))
                    cnt += 1;
            }

            if (cnt > L/2 || cnt == 0)
                return;
            
            sb.append(s + "\n");
        }

        for (int i = idx; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePassword(depth+1, i);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        stream = br.readLine().split(" ");
        Arrays.sort(stream);

        makePassword(0, 0);

        System.out.println(sb);
    }
}
