package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String pw = br.readLine();
            if (pw.equals("end")) {
                break;
            }

            if (checkPassword(pw)) {
                sb.append("<").append(pw).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(pw).append("> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean checkPassword(String pw) {

        boolean hasVowel = false;
        int vCnt = 0;
        int cCnt = 0;

        for (int i = 0; i < pw.length(); i++) {
            char cur = pw.charAt(i);
            boolean isV = isVowel(cur);

            if (isV) {
                hasVowel = true;
                vCnt++;
                cCnt = 0;
            } else {
                cCnt++;
                vCnt = 0;
            }

            if (cCnt == 3 || vCnt == 3) {
                return false;
            }

            if (i > 0) {
                char prev = pw.charAt(i - 1);
                if (cur == prev) {
                    if (cur != 'e' && cur != 'o') {
                        return false;
                    }
                }
            }
        }
        return hasVowel;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e';
    }
}
// S5 비밀번호 발음하기 완전탐색 복습
// 25분 복습치고 풀어볼만하네 신기하
// 일단 내가 푼거는 모든 조건을 1번씩 완탐으로 탐색하는 거였는데
// 다시 공부할때는 찾아보니 한번의 탐색으로 조건 모두를 검사할 수 있었다
// 먼저 pw 를 입력받고 첫번째로 이게 모음인지 여부와
// 해당 단어가 모음이거나 자음이면 연속되는 건 없는지 연속된 개수가 3개이상인지 를 검사하고
// 또 그 반복문이 통과되면 과거의 단어와 비교해서 일치하다면 e 나 o 가 아닌지도 점검해서
// 최종적으로 모음을 포함했냐는 플래그를 리턴하면 되었다.