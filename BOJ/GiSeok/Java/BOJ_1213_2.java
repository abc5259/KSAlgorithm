/**
 * 1213 - 팰린드롬 만들기, 시도3
 * 문자열, 실버3, 실패..
 * 
 * 원래 풀고 있던 풀이로 정답을 만듦.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213_2 {

    static int[] cnt = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pal = br.readLine();

        char[] buf = new char[pal.length()];

        for (int i = 0; i < pal.length(); i++)
            cnt[pal.charAt(i) - 'A']++;

        int l = 0, r = pal.length() - 1;
        int odd = 0;
        char mid = '-';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0 && cnt[i] % 2 != 0) {
                odd++;
                if (odd < 2) mid = (char)(i + 'A');
            }

            for (int x = 0; x < cnt[i]/2; x++) {
                buf[l++] = (char)(i + 'A');
                buf[r--] = (char)(i + 'A');
            }
        }

        if (odd == 1 || odd == 0) {
            if (mid != '-')
                buf[l] = mid; 
            
            for (int x = 0; x < buf.length; x++)
                System.out.print(buf[x]);
            System.out.println();
        } else { System.out.println("I'm Sorry Hansoo"); }
    }
}
