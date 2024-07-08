/**
 * 구현, 브론즈4, 3분
 * 단어의 길이가 100을 넘지 않으므로 단어 하나하나 다 세어봐도 100 이하의 반복횟수를 가진다.
 * 단순 반복으로 충분히 해결가능.
 */

package BOJ.GiSeok.Java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808 {
    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++)
            alphabet[i] = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        for (int i = 0; i < S.length(); i++)
            alphabet[S.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++)
            System.out.print(alphabet[i] + " ");
        System.out.println();
    }
}
