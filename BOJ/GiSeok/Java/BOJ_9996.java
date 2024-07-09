/**
 * 9996 - 한국이 그리울 땐 서버에 접속하지
 * 문자열, 실버3
 * *를 기준으로 양옆의 문자열로 시작하고 끝나는 문자열을 찾는 문제이다.
 * 간단하게 풀 수 있는 문제인데 반례를 생각 못했음.
 * 문자열의 길이를 고려하지 않으면, aaa*a 패턴에 대해 aaa 라는 문자열도 정답처리가 된다.
 * 그래서 *에는 빈문자열이 들어갈 수 있으니까 최소한 aaaa보다는 긴 문자열만 정답으로 처리해야 문제를 풀 수 있다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.startsWith(pattern[0]) && s.endsWith(pattern[1]) && s.length() >= (pattern[0].length() + pattern[1].length()))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}
