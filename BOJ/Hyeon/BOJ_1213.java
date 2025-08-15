package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] count = new int[26];

        for (int i = 0; i < name.length(); i++) {
            count[name.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        char midChar = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('A' + i);
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                sb.append((char) ('A' + i));
            }
        }
        StringBuilder back = new StringBuilder(sb).reverse();

        if (oddCount == 1) {
            sb.append(midChar);
        }
        System.out.println(sb.append(back));
    }
}
// S3 팰린드롬 만들기 그리디
// 일단 풀었다. StringBuilder의 reverse를 활용해서 했다.