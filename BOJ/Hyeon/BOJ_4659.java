package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            boolean isPossible = false;

            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (isVowel(tmp)) {
                    isPossible = true;
                    break;
                }
            }
            if (!isPossible) {
                sb.append("<").append(str).append("> is not acceptable.").append("\n");
                continue;
            }

            for (int i = 0; i < str.length() - 1; i++) {
                if ((str.charAt(i) == str.charAt(i + 1) && (str.charAt(i) != 'e' && str.charAt(i) != 'o'))) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) {
                sb.append("<").append(str).append("> is not acceptable.").append("\n");
                continue;
            }

            for (int i = 0; i < str.length() - 2; i++) {
                boolean vowel = isVowel(str.charAt(i));

                if (vowel) {
                    if (isVowel(str.charAt(i + 1)) && isVowel(str.charAt(i + 2))) {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (!isVowel(str.charAt(i + 1)) && !isVowel(str.charAt(i + 2))) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (!isPossible) {
                sb.append("<").append(str).append("> is not acceptable.").append("\n");
            } else {
                sb.append("<").append(str).append("> is acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e';
    }
}
// S5 비밀번호 발음하기 완전탐색
// 그냥 시키는 대로 했어