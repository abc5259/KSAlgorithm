/**
 * 1159 - 농구 경기
 * 구현, 브론즈2
 * 성의 첫 글자가 같은 문자 5개를 찾는 문제이다.
 * 정렬하면 성의 첫 글자가 같은 문자들이 모이게 되는 것을 이용해서
 * 해당 성의 글자가 계속 같으면 cnt++, 이 후 cnt가 5면 그 글자를 출력
 * 다르게 되는 순간에는 그 글자부터 다시 cnt = 1해서 카운트한다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1159 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] s = new String[N];
        for (int i = 0; i < N; i++)
            s[i] = br.readLine();

        Arrays.sort(s);

        int cnt = 1; boolean oneTime = false;
        for (int i = 1; i < N; i++) {
            if (s[i].charAt(0) == s[i-1].charAt(0))
                cnt++;
            else
                cnt = 1;

            if (cnt == 5) {
                System.out.print(s[i].charAt(0));
                oneTime = true;
            }

        }
        if (!oneTime)
            System.out.print("PREDAJA");
        System.out.println();
    }
}
