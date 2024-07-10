/**
 * 1213 - 팰린드롬 만들기, 시도3
 * 문자열, 실버3, 실패..
 * 
 * 생각보다 어려웠던 문제이다. 팰린드롬의 규칙성? 같은 것이 있는데.
 * 갯수가 홀수가 되는 알파벳이 0~1개이면 팰린드롬을 만들 수 있지만
 * 홀수가 2개 이상이면 팰린드롬을 만들 수 없다. 해당 내용을 알았는데 구현에서 어려움 겪음..
 * for (int x = 0; x < cnt[i] / 2; x++) ~ 로직을 생각하는 것이 어려웠다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {

    static int[] cnt = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pal = br.readLine();
        
        for (int i = 0; i < pal.length(); i++)
            cnt[pal.charAt(i) - 'A']++;

        int odd = 0;
        String first = "";
        char mid = '-';
        String end = "";
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0 && cnt[i] % 2 == 1) {
                if (odd == 0) { odd++; mid = (char)(i + 'A'); }
                else { System.out.println("I'm Sorry Hansoo"); System.exit(0); }
            }

            for (int x = 0; x < cnt[i] / 2; x++) { first += (char)('A' + i); end += (char)('A' + i); }
        }

        String rev = "";
        for (int i = end.length() - 1; i >= 0; i--)
            rev += end.charAt(i);
        if (mid == '-')
            first += rev;
        else
            first = first + mid + rev;
        System.out.println(first);
    }
}
