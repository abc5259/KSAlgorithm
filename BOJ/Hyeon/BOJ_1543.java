package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String str = br.readLine();

        int cnt = 0;
        int idx = 0;

        while (true) {
            int find = text.indexOf(str, idx);
            if (find < 0) {
                break;
            }
            cnt++;
            idx = find + str.length();
        }
        System.out.print(cnt);
    }
}
// S5 문서 검색 문자열
// 20분
// 카카오 1번이랑 비슷한 느낌이라서 한번 풀어봤는데 그냥 반례고 뭐고
// 내가 반복문으로 잘못 접근했엇다
// 단어를 겹치지 않게 세는게 중요하다
// i를 1씩 증가하면서 반복하면 계속 문자를 검사하는건데
// 우리는 단어 별로 보는거니까