/**
 * 1159 - 농구 경기
 * 구현, 브론즈2
 * 아까는 단어의 배열을 정렬해서 단어의 첫 글자끼리 모이게한 뒤 같은 문자의 경우 cnt++
 * 다른 문자의 경우 cnt = 1로 만들고 다시 cnt하는 방법이었음.
 * 이번 풀이는 입력 시에 첫 글자의 알파벳을 배열 인덱스로 활용해 cnt 배열에 ++ 하는 방식
 * 그 후 해당 배열을 순회하면서 5 이상이 되는 인덱스를 출력
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1159_2 {

    static int[] cnt = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            cnt[br.readLine().charAt(0) - 'a']++;

        String ret = "";
        for (int i = 0; i < 26; i++)
            if (cnt[i] >= 5) ret += (char)(i + 'a');
        
        if (ret.length() == 0) ret = "PREDAJA";
        System.out.println(ret);
    }
}
