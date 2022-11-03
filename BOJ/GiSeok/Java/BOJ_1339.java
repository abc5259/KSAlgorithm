// 그리디 - boj.kr/1339 단어 수학
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] exp = new String[N];
        Integer[] alpha = new Integer[26];
        for (int i = 0; i < 26; i++)
            alpha[i] = 0;

        for (int i = 0; i < N; i++) {
            exp[i] = br.readLine();
            
            for (int j = exp[i].length(); j > 0; j--) {
                char ch = exp[i].charAt(exp[i].length()-j);
                alpha[ch - 65] += (int)Math.pow(10, j-1);
            }
        }
        Arrays.sort(alpha, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 10; i++)
            ans += alpha[i] * (9-i);
        System.out.println(ans);
    }
}
