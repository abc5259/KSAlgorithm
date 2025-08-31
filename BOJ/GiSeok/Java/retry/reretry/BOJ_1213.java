package BOJ.GiSeok.Java.retry.reretry;

// 00:52:37
import java.util.*;
import java.io.*;

public class BOJ_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 알파벳 갯수를 저장해서. A B C D E F G ...
        // i = 0; i < 26; i++ 하면서 해당 알파벳 하나씩 붙이면 되는 거 아닌가?
        int[] alphabet = new int[26];
        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'A']++;
        }

        int odd = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) {
                continue;
            }
            if (alphabet[i] % 2 != 0) {
                odd++;
            }

            if (odd >= 2) {
                sb = new StringBuilder("I'm Sorry Hansoo");
                break;
            } else {
                if (sb.length() % 2 == 0) {
                    int idx = sb.length() / 2;
                    int cnt = alphabet[i];

                    String tmp = "";
                    while (cnt > 0) {
                        tmp += (char) (i + 'A');
                        cnt--;
                    }

                    sb.insert(idx, tmp);
                } else {
                    int cnt = alphabet[i];
                    while (cnt > 0) {
                        int idx = sb.length() / 2;
                        sb = new StringBuilder(sb.substring(0, idx)
                            + (char) (i + 'A')
                            + sb.substring(idx, idx + 1)
                            + (char) (i + 'A')
                            + sb.substring(idx + 1)
                        );

                        cnt -= 2;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
