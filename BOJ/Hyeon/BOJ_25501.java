package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(isPalindrome(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    static String isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1, 1);
    }

    static String recursion(String str, int l, int r, int cnt) {
        if (l >= r) {
            return 1 + " " + cnt;
        } else if (str.charAt(l) != str.charAt(r)) {
            return 0 + " " + cnt;
        } else {
            return recursion(str, l + 1, r - 1, ++cnt);
        }
    }
}

// B2 재귀의 귀재 재귀
// 걍 풀었음