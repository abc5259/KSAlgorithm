package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res = 0;
        int cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;
                if (N == cnt) {
                    res++;
                    cnt--;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(res);
    }
}
// 문자열문제
// 문자열 검색 부분 indexOf는 O(N)이고 subSTring도 O(N)
// 그냥 시간초과 안하게끔 subString과 indexOf를 안써야 했다 얘네는 O(N^2)이고
// 다음 인덱스 확인할 거면 범위를 줄여서 해야된다.
