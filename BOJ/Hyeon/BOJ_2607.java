package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int strLen = str.length();

        int cnt = 0;

        while (N-- > 1) {
            String input = br.readLine();

            int inputLen = input.length();

            if (Math.abs(strLen - inputLen) > 1) {
                continue;
            }
            int matchCnt = getCnt(str, input);

            if (strLen == inputLen) {
                if (matchCnt == strLen || matchCnt == strLen - 1) {
                    cnt++;
                }
            } else if (strLen < inputLen) {
                if (matchCnt == strLen) {
                    cnt++;
                }
            } else {
                if (matchCnt == inputLen) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static int getCnt(String str, String input) {
        int res = 0;

        boolean[] visit = new boolean[input.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (str.charAt(i) == input.charAt(j) && !visit[j]) {
                    visit[j] = true;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
// S2 비슷한 단어 문자열
// 14분
// 일단 풀었다. 문자열 비교 더하거나 빼거나 바꾸거나 등에 대해서
// 길이가 2이상 차이나면 가전조회로 반환 getCnt 로 반복문 이중으로 돌며 각 자리 방문 및
// res 로 개수 반환 즉 중복 글자 구하기.