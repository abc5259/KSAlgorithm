package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {

    static boolean[] alpha = new boolean[26];
    static int n, k;
    static String[] inputs;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // anta ~ tica
        // a n t i c = 5개는 무조건 배우고 시작
        k -= 5;
        // 5개도 못배우면 걍 남극 단어 못 읽음
        if (k < 0) {
            System.out.println(0);
            return;
        }

        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;

        inputs = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            inputs[i] = input.substring("anta".length(), input.length() - "tica".length());
        }

        dfs(k, 0);
        System.out.println(ans);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt <= 0) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (isWord(i)) tmp++;
            }

            ans = Math.max(ans, tmp);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!alpha[i]) {
                alpha[i] = true;
                dfs(cnt - 1, i + 1);
                alpha[i] = false;
            }
        }
    }

    private static boolean isWord(int idx) {
        for (int i = 0; i < inputs[idx].length(); i++) {
            if (!alpha[inputs[idx].charAt(i) - 'a']) return false;
        }
        return true;
    }
}
