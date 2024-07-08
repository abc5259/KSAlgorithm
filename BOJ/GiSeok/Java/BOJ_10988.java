/**
 * 구현, 브론즈3
 * 거꾸로 읽어도 똑같은 단어를 판별하는 문제
 * 그냥 거꾸로 돌려서 비교하면 된다.
 */

package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--)
            reverse += word.charAt(i);

        if (word.equals(reverse))
            System.out.println(1);
        else
            System.out.println(0); 
    }
}
