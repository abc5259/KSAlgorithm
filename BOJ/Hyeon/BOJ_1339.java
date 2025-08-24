package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            int length = charArray.length;
            for (char al : charArray) {
                cnt[al - 'A'] += (int) Math.pow(10, length-- - 1);
            }
        }
        Arrays.sort(cnt);

        int res = 0;
        int num = 9;
        for (int i = 25; i > 0; i--) {
            if (cnt[i] == 0) {
                break;
            }
            res += cnt[i] * (num--);
        }
        System.out.println(res);
    }
}
// G4 단어 수학 그리디
// 알파벳 26개에서 해당 알파벳에 가중치를 부여해서 내림차순을하고 num을 9부터 나열하게 해서 했다.