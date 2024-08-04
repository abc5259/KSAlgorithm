/**
 * 1062 - 가르침 [성공|00:30:18]
 * 골드4, 비트마스킹, 시도1
 * 
 * 
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1062 {
    // 시간제한 1초, 메모리제한 128MB
    // K개의 글자를 가르칠 시간밖에 없음
    // 가르침 후 학생들은 K개의 글자로만 이루어진 단어만 읽을 수 있다.
    // 주어진 단어 N개 중 가장 많은 단어를 익힐 수 있는 K개의 글자를 찾아 읽을 수 있는 단어 수 출력
    // 모든 남극 언어는 "anta"로 시작해서 "tica"로 끝난다.
    // a, n, t, i, c는 무조건 포함되어야 하니까 K < 5면 무조건 0
    // K >= 5면 모든 조합으로 한번씩 돌려본다. 조합의 경우 최대가 21C10 == 352716
    // N이 최대 50이니까 50개 문자열 전부 최대 7번 돌리면 대충 약 1억 해볼만?

    static int N, K;
    static int ret = 0;
    static int[] str;
    static int words;

    static void dfs(int start, int k, int word) {
        if (k == (K - 5)) {
            int cnt = 0;
            for (int i = 0; i < str.length; i++)
                if ((word & str[i]) == str[i]) cnt++;

            ret = Math.max(ret, cnt);
            return;
        }

        for (int i = start + 1; i < 26; i++) {
            if ((word & (1 << i)) >= 1) continue;
            
            dfs(i, k + 1, word | (1 << i));
        }
    }

    static void init() {
        words |= (1 << 'a' - 'a');
        words |= (1 << 'n' - 'a');
        words |= (1 << 't' - 'a');
        words |= (1 << 'i' - 'a');
        words |= (1 << 'c' - 'a');
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        str = new int[N];
        for (int i = 0; i < N; i++) {
            String m = br.readLine();
            for (int j = 4; j < m.length() - 4; j++) {
                str[i] |= 1 << (m.charAt(j) - 'a');
            }
        }
        
        if (K >= 5) {
            init();
            dfs(-1, 0, words);
        }

        System.out.println(ret);

    }
}
